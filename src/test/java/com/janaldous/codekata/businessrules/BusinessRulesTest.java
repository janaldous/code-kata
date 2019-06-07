package com.janaldous.codekata.businessrules;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.janaldous.codekata.businessrules.domain.Payment;
import com.janaldous.codekata.businessrules.domain.PaymentType;
import com.janaldous.codekata.businessrules.domain.PhysicalOrder;
import com.janaldous.codekata.businessrules.domain.PhysicalOrderType;
import com.janaldous.codekata.businessrules.operation.Command;
import com.janaldous.codekata.businessrules.operation.impl.AgentCommissionPaymentOperation;
import com.janaldous.codekata.businessrules.operation.impl.MembershipPaymentOperation;
import com.janaldous.codekata.businessrules.operation.impl.PackingSlipDuplicationOperation;
import com.janaldous.codekata.businessrules.operation.impl.PackingSlipOperation;
import com.janaldous.codekata.businessrules.rule.impl.BookRule;
import com.janaldous.codekata.businessrules.rule.impl.MembershipRule;
import com.janaldous.codekata.businessrules.rule.impl.ProductRule;
import com.janaldous.codekata.businessrules.rule.impl.ProductRule2;
import com.janaldous.codekata.businessrules.tree.BusinessRuleNode;
import com.janaldous.codekata.businessrules.tree.BusinessRuleTree;

public class BusinessRulesTest {

	private BusinessRuleTree tree;

	@Before
	public void setUp() {
		BusinessRuleNode nodeProd = new BusinessRuleNode(new ProductRule2());
		BusinessRuleNode leafBook = new BusinessRuleNode(new BookRule());
		BusinessRuleNode nodeProduct = new BusinessRuleNode(new ProductRule());
		BusinessRuleNode leafMembership = new BusinessRuleNode(new MembershipRule());
		BusinessRuleNode root = new BusinessRuleNode(null);
		root.addChild(leafMembership);
		root.addChild(nodeProduct);
		nodeProduct.addChild(leafBook);
		nodeProduct.addChild(nodeProd);
		
		assertEquals(2, root.children().size());
		
		tree = new BusinessRuleTree(root);
	}
	
	@Test
	public void testProductPayment() {
		Payment payment = new Payment();
		payment.setType(PaymentType.PRODUCT);
		
		List<Command> operations = tree.getOperations(payment);
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof PackingSlipOperation);
	}
	
	@Test
	public void testMembershipPayment() {
		Payment payment = new Payment();
		payment.setType(PaymentType.MEMBERSHIP);
		
		List<Command> operations = tree.getOperations(payment);
		
		assertEquals(1, operations.size());
		assertTrue(operations.get(0) instanceof MembershipPaymentOperation);
	}
	
	@Test
	public void testBookPayment() {
		PhysicalOrder order = new PhysicalOrder();
		order.setType(PhysicalOrderType.BOOK);

		Payment payment = new Payment();
		payment.setType(PaymentType.PRODUCT);
		payment.setOrder(order);
		
		List<Command> operations = tree.getOperations(payment);
		
		assertEquals(3, operations.size());
		assertThat(operations, containsInAnyOrder(
                new PackingSlipDuplicationOperation(payment),
                new PackingSlipOperation(payment),
                new AgentCommissionPaymentOperation(payment)
        ));
	}
	
	@Test
	public void testOtherProductPayment() {
		PhysicalOrder order = new PhysicalOrder();
		order.setType(PhysicalOrderType.OTHER);

		Payment payment = new Payment();
		payment.setType(PaymentType.PRODUCT);
		payment.setOrder(order);
		
		List<Command> operations = tree.getOperations(payment);
		
		assertEquals(2, operations.size());
		assertThat(operations, containsInAnyOrder(
                new PackingSlipOperation(payment),
                new AgentCommissionPaymentOperation(payment)
        ));
	}
	

}
