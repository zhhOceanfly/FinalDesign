package com.xidian.stuweb.notice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class NoticeService {
	private NoticeDao noticeDao;
	

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void saveNotice(Notice notice) {
		noticeDao.saveNotice(notice);
		
	}

	public List<Notice> findAllNotice() {
		return noticeDao.findAllNotice();
	}

	public Notice findByNid(Integer nid) {
		return noticeDao.findByNid(nid);
	}

	public void deleteByNid(Notice notice) {

		noticeDao.deleteByNid(notice);
	}
	
}
