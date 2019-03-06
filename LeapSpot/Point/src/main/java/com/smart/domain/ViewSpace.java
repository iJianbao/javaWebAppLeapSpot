package com.smart.domain;
//使用注解加载实体

import javax.persistence.*;
import java.io.Serializable;

//Hibernate数据库对象
@Entity
@Table(name = "myTest.t_view_space")
public class ViewSpace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "space_id")
    protected int spaceId;
    @Column(name = "space_name")
    protected String spaceName;
    @Column(name = "img_file")
    protected byte[] imgFile;
    protected String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImgFile() {
        return imgFile;
    }

    public void setImgFile(byte[] imgFile) {
        this.imgFile = imgFile;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }
}
