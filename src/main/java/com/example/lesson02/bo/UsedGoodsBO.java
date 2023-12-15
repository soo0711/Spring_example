package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	// 필드
	@Autowired // Dependency Injection(DI): 의존성 주입
			   //간단하게 말하면 Spring bean을 new를 할 수 없기 때문에 어노테이션으로 Spring bean을 가져온다.
	private UsedGoodsMapper usedGoodMapper; // new를 하지않아도 있다.
	

	// (Controller한테 받아오는) input:X     
	// (Repository한테 받은 것을, Controller한테 주는) output:List<UsedGoods> 
	public List<UsedGoods> getUsedGoodsList(){
		return usedGoodMapper.selectUsedGoodsList();
	}
}
