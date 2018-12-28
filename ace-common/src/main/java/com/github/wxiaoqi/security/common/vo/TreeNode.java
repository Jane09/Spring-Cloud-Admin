package com.github.wxiaoqi.security.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace on 2017/6/12.
 */
@Getter
@Setter
public class TreeNode {

    protected int id;
    protected int parentId;
    private List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node){
        children.add(node);
    }
}
