package com.wivesidedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/31.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Contact> contacts;

    public MyAdapter() {
        contacts = new ArrayList<>();
        contacts.addAll(getEnglishContacts());
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(position);
    }


    @Override
    public int getItemCount() {
        if (contacts != null) {
            return contacts.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_index;
        TextView tv_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_index = itemView.findViewById(R.id.tv_index);
            tv_name = itemView.findViewById(R.id.tv_name);
        }

        public void bindData(int position) {
            Contact contact = contacts.get(position);
            tv_index.setText(contact.getIndex());
            tv_name.setText(contact.getName());

            if (position == 0 || !(contacts.get(position - 1).getIndex().equals(contact.getIndex()))) {
                tv_index.setVisibility(View.VISIBLE);
            } else {
                tv_index.setVisibility(View.GONE);
            }
        }
    }

    public static List<Contact> getEnglishContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("A", "Abbey"));
        contacts.add(new Contact("A", "Alex"));
        contacts.add(new Contact("A", "Amy"));
        contacts.add(new Contact("A", "Anne"));
        contacts.add(new Contact("B", "Betty"));
        contacts.add(new Contact("B", "Bob"));
        contacts.add(new Contact("B", "Brian"));
        contacts.add(new Contact("C", "Carl"));
        contacts.add(new Contact("C", "Candy"));
        contacts.add(new Contact("C", "Carlos"));
        contacts.add(new Contact("C", "Charles"));
        contacts.add(new Contact("C", "Christina"));
        contacts.add(new Contact("D", "David"));
        contacts.add(new Contact("D", "Daniel"));
        contacts.add(new Contact("E", "Elizabeth"));
        contacts.add(new Contact("E", "Eric"));
        contacts.add(new Contact("E", "Eva"));
        contacts.add(new Contact("F", "Frances"));
        contacts.add(new Contact("F", "Frank"));
        contacts.add(new Contact("I", "Ivy"));
        contacts.add(new Contact("J", "James"));
        contacts.add(new Contact("J", "John"));
        contacts.add(new Contact("J", "Jessica"));
        contacts.add(new Contact("K", "Karen"));
        contacts.add(new Contact("K", "Karl"));
        contacts.add(new Contact("K", "Kim"));
        contacts.add(new Contact("L", "Leon"));
        contacts.add(new Contact("L", "Lisa"));
        contacts.add(new Contact("P", "Paul"));
        contacts.add(new Contact("P", "Peter"));
        contacts.add(new Contact("S", "Sarah"));
        contacts.add(new Contact("S", "Steven"));
        contacts.add(new Contact("R", "Robert"));
        contacts.add(new Contact("R", "Ryan"));
        contacts.add(new Contact("T", "Tom"));
        contacts.add(new Contact("T", "Tony"));
        contacts.add(new Contact("W", "Wendy"));
        contacts.add(new Contact("W", "Will"));
        contacts.add(new Contact("W", "William"));
        contacts.add(new Contact("Z", "Zoe"));
        return contacts;
    }
}
