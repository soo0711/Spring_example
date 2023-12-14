package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {

	// (Controller한테 받아오는) input:X     
	// (Repository한테 받은 것을, Controller한테 주는) output:List<UsedGoods> 
	public List<UsedGoods> getUsedGoodsList(){
		return ;
	}
}
