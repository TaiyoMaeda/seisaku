CREATE TABLE `gakuseihyou` (
    `id` SERIAL NOT NULL COMMENT 'id',
    `studentnumber` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学生番号',
    `name` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '名前',
    `age` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '年齢',
    `mail` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT 'メールアドレス',
    `phone` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '電話番号',
    `password` VARCHAR(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT 'パスワード',
    PRIMARY KEY (`studentnumber`)
) ENGINE=InnoDB;