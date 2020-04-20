package classes_objects;

import java.util.List;
public interface DAO{
    //增加
    public void add(Item it);
    //修改
    public void update(Item it);
    //删除
    public void delete(int id);
    //获取
    public Item get(int id);
    //查询
    public List<Item> list();
    //分页查询
    public List<Item> list(int start, int count);
}