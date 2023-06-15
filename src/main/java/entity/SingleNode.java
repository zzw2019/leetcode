package entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName SingleLink
 * @Author Zengzhw
 * @Date 2023/6/13 21:05
 * @Description SingleLink
 * @Version 1.0
 *
 * 单向链表
 */
@Data
@Builder
public class SingleNode {
    private Integer value;

    private SingleNode next;
}
