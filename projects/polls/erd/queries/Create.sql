
CREATE TABLE ANSWER
(
  unique_A INT          NOT NULL COMMENT 'unique_A',
  ANSWER   VARCHAR(200) NULL     COMMENT 'ANS',
  PRIMARY KEY (unique_A)
) COMMENT '대답';

CREATE TABLE FINAL
(
  unique_Name VARCHAR(200) NOT NULL COMMENT 'unique_Name',
  unique_Q    INT NOT NULL COMMENT 'unique_Q',
  unique_A    INT NOT NULL COMMENT 'unique_A'
) COMMENT '최종';

CREATE TABLE Information
(
  NAME        VARCHAR(200) NOT NULL COMMENT 'NAME',
  unique_Name VARCHAR(200)          NOT NULL COMMENT 'unique_Name',
  PRIMARY KEY (unique_Name)
) COMMENT '기본정보';

CREATE TABLE QUESTION
(
  unique_Q INT          NOT NULL COMMENT 'unique_Q',
  QUESTION VARCHAR(200) NULL     COMMENT 'Q',
  PRIMARY KEY (unique_Q)
) COMMENT '문항';

ALTER TABLE FINAL
  ADD CONSTRAINT FK_Information_TO_FINAL
    FOREIGN KEY (unique_Name)
    REFERENCES Information (unique_Name);

ALTER TABLE FINAL
  ADD CONSTRAINT FK_QUESTION_TO_FINAL
    FOREIGN KEY (unique_Q)
    REFERENCES QUESTION (unique_Q);

ALTER TABLE FINAL
  ADD CONSTRAINT FK_ANSWER_TO_FINAL
    FOREIGN KEY (unique_A)
    REFERENCES ANSWER (unique_A);
