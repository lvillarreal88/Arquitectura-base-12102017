package com.cosmo.arquitecturamvpbase.synchronizer;

import android.util.Log;

import com.cosmo.arquitecturamvpbase.helper.Database;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.repository.ProductRepository;

import java.util.ArrayList;

/**
 * Created by leonardo on 12/10/2017.
 */

public class Synchronizer {

    private static final String TAG_CLASS = ":: * Synchronizer * ::";
    public static Synchronizer instance;
    private ProductRepository productRepository = new ProductRepository();

    public static Synchronizer getInstance(){
        if(instance == null){
            instance = new Synchronizer();
        }
        return instance;
    }

    public void executeSyncLocalToServer(boolean isConnected) {
        //TODO
        Log.i(TAG_CLASS, "Network changed: "+ isConnected);

        if(isConnected){
            ArrayList<Product> alstProduct = Database.productDao.fetchAllProducts();

            for (Product p: alstProduct) {
                // Se sincroniza el producto
                Log.e(":: ERROR ACTUAL ::", p.getSync()+" === "+ p.getName());
                if(p.getSync() == null || !p.getSync().equals("1")) {
                    p.setSync("1");
                    productRepository.createProduct(p);
                    Database.productDao.updateProduct(p.getId(),p);
                }

            }
        }
    }
}
