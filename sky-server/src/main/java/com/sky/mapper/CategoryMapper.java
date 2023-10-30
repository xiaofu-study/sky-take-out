package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.aspect.AutoFillAspect;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 新增菜品
     * @param category
     */
    @Insert("insert into category(type,name,sort,status,create_time,update_time,create_user,update_user)" +
            "values " +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    List<Category> list(Integer type);

    /**
     * 启用、禁用分类
     *
     * @param category
     * @return
     */

    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 删除分类
     * @param id
     */
    @Delete("DELETE from category where id = #{id}")
    void delete(Long id);
}
