package entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author zengzw
 * @version 1.0
 * @description BinaryTree
 * @since 2023/6/20 15:42
 *
 * 二叉树实体类
 */
@Data
@Builder
public class BinaryTree {
    private Integer value;
    private BinaryTree leftSon;
    private BinaryTree rightSon;
}
