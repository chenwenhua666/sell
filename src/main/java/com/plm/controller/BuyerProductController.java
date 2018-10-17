package com.plm.controller;

import com.plm.dataobject.ProductCategory;
import com.plm.dataobject.ProductInfo;
import com.plm.service.ProductCategoryService;
import com.plm.service.ProductInfoService;
import com.plm.utils.ResultVOUtil;
import com.plm.vo.ProductInfoVO;
import com.plm.vo.ProductVO;
import com.plm.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * chenwenhua
 * 2018\9\8 0008
 * 20:02
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;


    @GetMapping("/list")
    public ResultVO list(){
        //查询所有已上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        //查询商品类目
        List<ProductCategory> productCategoryList = productCategoryService
                .findByCategoryTypeIn(categoryTypeList);

        //拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }
        return ResultVOUtil.success(productVOList);
    }

}
