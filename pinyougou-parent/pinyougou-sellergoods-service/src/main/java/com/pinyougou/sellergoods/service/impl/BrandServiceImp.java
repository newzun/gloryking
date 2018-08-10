package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title: gloryking
 * Title: com.pinyougou.sellergoods.service.impl
 * Descripton:
 * Company:www.newzun.com
 *
 * @author: GloryKing
 * Date:2018/8/10
 */
@Service
@Transactional
public class BrandServiceImp implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page= (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getResult(),page.getTotal());

    }
    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, Integer pageNum, Integer pageSize) {
        //设置分页查询条件
        PageHelper.startPage(pageNum, pageSize);

        TbBrandExample example = new TbBrandExample();
        //条件封装对象
        TbBrandExample.Criteria criteria = example.createCriteria();

        if(brand!=null) {
            String brandName = brand.getName();
            //品牌名称条件封装
            if(brandName!=null && !"".equals(brandName)) {
                criteria.andNameLike("%"+brandName+"%");
            }
            //品牌首字母条件封装
            String firstChar = brand.getFirstChar();
            if(firstChar!=null && !"".equals(firstChar)) {
                criteria.andFirstCharEqualTo(firstChar);
            }
        }

        Page<TbBrand> pageData = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageResult(pageData.getResult(), pageData.getTotal());
    }

}
