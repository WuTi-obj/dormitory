package com.wuti.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuti
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Dormitory implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer buildingId;

    private String name;

    private Integer type;

    private Integer available;

    private String telephone;


}
