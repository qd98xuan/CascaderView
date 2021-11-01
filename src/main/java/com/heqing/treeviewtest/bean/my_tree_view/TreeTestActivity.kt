package com.heqing.treeviewtest.bean.my_tree_view

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.heqing.treeviewtest.R
import com.heqing.treeviewtest.bean.my_tree_view.NodeHelper.sortNodes
import java.util.*

/**
 * Created by HQOCSHheqing on 2016/8/4.
 *
 * @description
 */
class TreeTestActivity : Activity() {
    private var mListView: ListView? = null
    private var mAdapter: NodeTreeAdapter? = null
    private val mLinkedList = LinkedList<Node<*>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_dept_layout)
        mListView = findViewById(R.id.id_tree) as ListView
        mAdapter = NodeTreeAdapter(this, mListView!!, mLinkedList,true,object :OnTreeClickCallback{
            override fun onItemClickListener(id: String, parentId: String, name: String,type:Int) {

            }
        })
        mListView!!.adapter = mAdapter
        initData()
    }

    private fun initData() {
        val data: MutableList<Node<*>> = ArrayList()
        addOne(data)
        mLinkedList.addAll(sortNodes(data)!!)
        mAdapter!!.notifyDataSetChanged()
    }

    private fun addOne(data: MutableList<Node<*>>) {
        data.add(Dept("1", "0", "总公司")) //可以直接注释掉此项，即可构造一个森林
        data.add(Dept("2", "1", "一级部一级部门一级部门一级部门门级部门一级部门级部门一级部门一级部门门级部一级"))
        data.add(Dept("3", "1", "一级部门"))
//        data.add(Dept(4, 1, "一级部门"))
//        data.add(Dept(222, 5, "二级部门--测试1"))
//        data.add(Dept(223, 5, "二级部门--测试2"))
//        data.add(Dept(5, 1, "一级部门"))
//        data.add(Dept(224, 5, "二级部门--测试3"))
//        data.add(Dept(225, 5, "二级部门--测试4"))
//        data.add(Dept(6, 1, "一级部门"))
//        data.add(Dept(7, 1, "一级部门"))
//        data.add(Dept(8, 1, "一级部门"))
//        data.add(Dept(9, 1, "一级部门"))
//        data.add(Dept(10, 1, "一级部门"))
//        for (i in 2..10) {
//            for (j in 0..9) {
//                data.add(Dept(1 + (i - 1) * 10 + j, i, "二级部门$j"))
//            }
//        }
//        for (i in 0..4) {
//            data.add(Dept(101 + i, 11, "三级部门$i"))
//        }
//        for (i in 0..4) {
//            data.add(Dept(106 + i, 22, "三级部门$i"))
//        }
//        for (i in 0..4) {
//            data.add(Dept(111 + i, 33, "三级部门$i"))
//        }
//        for (i in 0..4) {
//            data.add(Dept(115 + i, 44, "三级部门$i"))
//        }
//        for (i in 0..4) {
//            data.add(Dept(401 + i, 101, "四级部门$i"))
//        }
    }
}