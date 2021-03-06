package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: gloryking
 * Title: com.pinyougou.manager.controller
 * Descripton:
 * Company:www.newzun.com
 *
 * @author: GloryKing
 * Date:2018/8/10
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }
    @RequestMapping("/findPage")
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        return brandService.findPage(pageNum,pageSize);
    }
    //添加品牌数据
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
        try {
            brandService.add(brand);
            return new Result(true, "添加品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加品牌失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    //修改品牌数据
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改品牌失败");
        }
    }

    //删除品牌数据
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除品牌失败");
        }
    }

    /**
     * 条件分页查询
     * brand:封装查询条件
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, Integer pageNum, Integer pageSize) {
        return brandService.findPage(brand,pageNum,pageSize);
    }

}
