package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * Title: gloryking
 * Title: com.pinyougou.sellergoods.service
 * Descripton:
 * Company:www.newzun.com
 *
 * @author: GloryKing
 * Date:2018/8/10
 */
public interface BrandService {
    public List<TbBrand> findAll();
    public PageResult findPage(Integer pageNum, Integer pageSize);
    public void add(TbBrand brand);

    public TbBrand findOne(Long id);

    public void update(TbBrand brand);

    public void delete(Long[] ids);

    public PageResult findPage(TbBrand brand, Integer pageNum, Integer pageSize);
}
