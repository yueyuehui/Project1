package com.jk.service;

import com.jk.model.Journal;
import com.jk.model.MenuTree;
import com.jk.model.Power;

import java.util.List;

/**
 * Created by Mr.wangbin on 2017/11/14.
 */
public interface TreeService {

    public List<Power> treelist();
    public List<Journal> jourList();
}
