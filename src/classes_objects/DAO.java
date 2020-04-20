package classes_objects;

import java.util.List;
public interface DAO{
    //����
    public void add(Item it);
    //�޸�
    public void update(Item it);
    //ɾ��
    public void delete(int id);
    //��ȡ
    public Item get(int id);
    //��ѯ
    public List<Item> list();
    //��ҳ��ѯ
    public List<Item> list(int start, int count);
}