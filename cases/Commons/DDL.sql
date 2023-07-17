
CREATE TABLE COMMONS_CODE
(
  COMMON_CODE_ID        varchar(40)   NOT NULL COMMENT '공통 코드_ID',
  NAME                  varchar(1000) NOT NULL COMMENT '명칭',
  ORDER_NUMBER          decimal       NULL     COMMENT '정렬순서',
  ATTRIBUTION_1         varchar(60)   NULL     COMMENT '속성_1',
  ATTRIBUTION_2         varchar(60)   NULL     COMMENT '속성_2',
  DESCRIPTION           varchar(1000) NULL     COMMENT '코드설명',
  SYSTEM_CODE_YN        varchar(40)   NOT NULL DEFAULT N COMMENT '초기 시스템 코드 여부',
  USE_YN                varchar(40)   NOT NULL COMMENT '사용 여부',
  REGISTER_SEQ          varchar(50)   NOT NULL COMMENT '등록자SEQ',
  REGISTRY_DATE         varchar(20)   NOT NULL COMMENT '등록일자',
  MODIFIER_SEQ          varchar(40)   NOT NULL COMMENT '수정자_SEQ',
  MODIFY_DATE           varchar(20)   NOT NULL COMMENT '수정일자',
  PARENT_COMMON_CODE_ID varchar(40)   NULL     COMMENT '상위_공통 코드_ID',
  PRIMARY KEY (COMMON_CODE_ID)
);

ALTER TABLE COMMONS_CODE
  ADD CONSTRAINT FK_COMMONS_CODE_TO_COMMONS_CODE
    FOREIGN KEY (PARENT_COMMON_CODE_ID)
    REFERENCES COMMONS_CODE (COMMON_CODE_ID);
