package org.zerock.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MsgVO {

	private Integer mno;
	private String whom, who, content;
	private LocalDateTime regdate, opendate;
	private Integer reply;
	
}
