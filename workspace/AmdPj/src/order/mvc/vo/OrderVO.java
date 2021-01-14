package order.mvc.vo;

import java.util.List;

import amd.domain.Cart;
import amd.domain.Member;
import amd.domain.Product;

public class OrderVO {
	private List<Product> listP;
	private List<Cart> listC;
	private Member member;
	
	public OrderVO(List<Product> listP, List<Cart> listC, Member member) {
		super();
		this.listP = listP;
		this.listC = listC;
		this.member = member;
	}

	public List<Product> getListP() {
		return listP;
	}

	public void setListP(List<Product> listP) {
		this.listP = listP;
	}

	public List<Cart> getListC() {
		return listC;
	}

	public void setListC(List<Cart> listC) {
		this.listC = listC;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
