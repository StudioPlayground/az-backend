CREATE TABLE account (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '계정아이디',
  name VARCHAR(255) NULL COMMENT '계정이름',
  birth_date DATE NULL COMMENT '계정생년월일',
  gender VARCHAR(64) NULL COMMENT '계정성별',
  status VARCHAR(64) NULL COMMENT '계정상태',
  role VARCHAR(64) NULL COMMENT '계정역할',
  created_by BIGINT NOT NULL COMMENT '작성자',
  created_at TIMESTAMP NOT NULL COMMENT '작성일시',
  modified_by BIGINT NOT NULL COMMENT '수정자',
  modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
) COMMENT '계정';