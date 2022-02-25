package com.kj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    // 字段尽量保证和数据库的一致
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
