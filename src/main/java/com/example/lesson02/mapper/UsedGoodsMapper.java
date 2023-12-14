package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository // spring bean
public interface UsedGoodsMapper { // interface여서 객체를 만들 수 없다.

	// (BO에게 받아오는) input: X
	// (BO에게 줘야하는) output: List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
