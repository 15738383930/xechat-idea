package cn.xeblog.entity;

import cn.xeblog.enums.Style;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anlingyi
 * @date 2020/8/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextRender {

    private String text;

    private Style style;

}
