package com.example.loginrespage;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Menu_page extends AppCompatActivity {

    private RecyclerView rcvItem;
    private ItemAdapter itemAdapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = findViewById(R.id.search_bar);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemAdapter.getFilter().filter(newText);
                return false;
            }
        });



        rcvItem = findViewById(R.id.rcv_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);

        itemAdapter = new ItemAdapter(this, getListItem());
        rcvItem.setAdapter(itemAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);



    }


    private List<Item> getListItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.item1,"Ếch xào sả ớt","330.000 VND","ếch, sả, ớt, tỏi, hành tím, nước mắm, muối, đường, tiêu, dầu ăn."));
        list.add(new Item(R.drawable.item2,"Đậu khuôn chiên giòn","120.000 VND","đậu hũ non, bột chiên giòn, bột chiên xù, trứng gà, muối."));
        list.add(new Item(R.drawable.item3,"Gỏi tôm","300.000 VND","tôm, mắm cá, tôm khô, chanh, ớt, tỏi, hành, đường nâu, nước mắm."));
        list.add(new Item(R.drawable.item4,"Tôm sốt me","200.000 VND", "tôm, me chín, bột bắp, ớt sừng, hành tím, tỏi, hành lá, đường, hạt nêm, tiêu xay, nước mắm."));
        list.add(new Item(R.drawable.item1,"Ếch xào sả ớt","330.000 VND","ếch, sả, ớt, tỏi, hành tím, nước mắm, muối, đường, tiêu, dầu ăn."));
        list.add(new Item(R.drawable.item2,"Đậu khuôn chiên giòn","120.000 VND","đậu hũ non,  bột chiên giòn, bột chiên xù, trứng gà, xà lách, dầu ăn, muối."));
        list.add(new Item(R.drawable.item3,"Gỏi tôm","300.000 VND","tôm, mắm cá, tôm khô, chanh, ớt, tỏi, hành, đường nâu, nước mắm."));
        list.add(new Item(R.drawable.item4,"Tôm sốt me","200.000 VND","tôm, me chín, bột bắp, ớt sừng, hành tím, tỏi, hành lá, đường, hạt nêm, tiêu xay, nước mắm."));
        list.add(new Item(R.drawable.item1,"Ếch xào sả ớt","330.000 VND","ếch, sả, ớt, tỏi, hành tím, nước mắm, muối, đường, tiêu, dầu ăn."));
        list.add(new Item(R.drawable.item2,"Đậu khuôn chiên giòn","120.000 VND","đậu hũ non, bột chiên giòn, bột chiên xù, trứng gà, muối."));
        list.add(new Item(R.drawable.item3,"Gỏi tôm","300.000 VND","tôm, mắm cá, tôm khô, chanh, ớt, tỏi, hành, đường nâu, nước mắm."));
        list.add(new Item(R.drawable.item4,"Tôm sốt me","200.000 VND", "tôm, me chín, bột bắp, ớt sừng, hành tím, tỏi, hành lá, đường, hạt nêm, tiêu xay, nước mắm."));
        list.add(new Item(R.drawable.item1,"Ếch xào sả ớt","330.000 VND","ếch, sả, ớt, tỏi, hành tím, nước mắm, muối, đường, tiêu, dầu ăn."));
        list.add(new Item(R.drawable.item2,"Đậu khuôn chiên giòn","120.000 VND","đậu hũ non,  bột chiên giòn, bột chiên xù, trứng gà, xà lách, dầu ăn, muối."));
        list.add(new Item(R.drawable.item3,"Gỏi tôm","300.000 VND","tôm, mắm cá, tôm khô, chanh, ớt, tỏi, hành, đường nâu, nước mắm."));
        list.add(new Item(R.drawable.item4,"Tôm sốt me","200.000 VND","tôm, me chín, bột bắp, ớt sừng, hành tím, tỏi, hành lá, đường, hạt nêm, tiêu xay, nước mắm."));

        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(itemAdapter!=null){
            itemAdapter.release();
        }
    }
}