package com.zsl.mybatis.service;

import com.zsl.mybatis.entity.Websites;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author : zsl
 * @date : Created in 2020/6/25 9:55 上午
 */
public interface WebsitesService {

    /**
     * 保存一个网址对象
     * @param websites 网址对象记录
     * @return 是否保存成功
     */
    public boolean saveWebsites(Websites websites);

    /**
     * 删除一个网址记录
     * @param id 网址主键id
     * @return 是否删除成功
     */
    public boolean deleteWebsites(Integer id);

    /**
     * 修改一个网址记录
     * @param websites 网址新记录
     * @return 是否修改成功
     */
    public boolean updateWebsites(Websites websites);

    /**
     * 更新alexa字段根据主键
     * @param id 主键
     * @param alexa 排名
     * @return 是否更新成功
     */
    public boolean updateWebsitesByAlexa(@Param("id") Integer id, @Param("alexa") Integer alexa);

    /**
     * 根据主键查找一条网址记录
     * @param id 主键
     * @return 返回查找对象
     */
    public Websites selectWebsitesById(Integer id);

    /**
     * 根据国家查询
     * @param country 国家
     * @return 返回集合
     */
    public List<Websites> selectWebsitesByCountry(String country);

    /**
     * 根据map来查询
     * @param map 查询
     * @return 返回记录
     */
    public Websites selectWebsitesByIdMap(HashMap<String, Object> map);

    /**
     * 根据map来查询
     * @param map 查询
     * @return 返回记录
     */
    public List<Websites> selectWebsitesByIdMapList(HashMap<String, Object> map);


}
