package com.cosmo.arquitecturamvpbase.services;

import com.cosmo.arquitecturamvpbase.model.Product;

import java.util.ArrayList;

import retrofit.http.GET;

/**
 * Created by leidyzulu on 16/09/17.
 */

public interface IServices {


    @GET("/product")
    ArrayList<Product> getProductList();
}
