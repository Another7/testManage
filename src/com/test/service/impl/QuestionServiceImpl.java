package com.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.FBQuestionDao;
import com.test.dao.MCQuestionDao;
import com.test.dao.QAQuestionDao;
import com.test.dao.SCQuestionDao;
import com.test.dao.TFQuestionDao;
import com.test.dao.TeacherDao;
import com.test.dao.TestPaperDao;
import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.SCQuestionData;
import com.test.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	SCQuestionDao scQuestionDao;
					
	@Autowired
	MCQuestionDao mcQuestionDao;

	@Autowired
	TFQuestionDao tfQuestionDao;

	@Autowired
	FBQuestionDao fbQuestionDao;

	@Autowired
	QAQuestionDao qaQuestionDao;
	
	@Autowired
	private TestPaperDao testPaperDao;
	
	@Autowired
	TeacherDao teacherDao;

	/* 添加单选题 */
	@Override
	public int saveSCQuestion(SCQuestionData scQuestionData) {

		Integer subject = scQuestionData.getSc_subject();
		String opint = scQuestionData.getSc_point();
		String stem = scQuestionData.getSc_stem();
		String option = scQuestionData.getSc_option();
		String answer = scQuestionData.getSc_answer();
		String analysis = scQuestionData.getSc_analysis();
		Integer c_id = scQuestionData.getSc_c_id();
		Integer ct_id = scQuestionData.getSc_ct_id();
		Integer level = scQuestionData.getSc_level();
		String username = "admin";
		SCQuestion scQuestion = new SCQuestion(subject, opint, stem, option, answer, analysis, username, c_id, ct_id,
				level);
		return scQuestionDao.saveSCQuestion(scQuestion);
	}

	/* 添加多选题 */
	@Override
	public int saveMCQuestion(MCQuestion mcQuestion) {
		String username = "admin";
		mcQuestion.setMc_t_name(username);
		return mcQuestionDao.saveMCQuestion(mcQuestion);
	}

	/* 添加填空题 */
	@Override
	public int saveFBQuestion(FBQuestion fbQuestion) {
		String username = "admin";
		fbQuestion.setFb_t_name(username);

		return fbQuestionDao.saveFBQuestion(fbQuestion);

	}

	/* 添加判断题 */
	@Override
	public int saveTFQuestion(TFQuestion tfQuestion) {
		String username = "admin";
		tfQuestion.setTf_t_name(username);
		return tfQuestionDao.saveTFQuestion(tfQuestion);
	}

	/* 添加简答题 */
	@Override
	public int saveQAQuestion(QAQuestion qaQuestion) {
		String username = "admin";
		qaQuestion.setQa_t_name(username);
		return qaQuestionDao.saveQAQuestion(qaQuestion);
	}

	/* 添加单选题 */
	@Override
	public List<SCQuestion> getAllSCQuestions(String subjectId) {

		Integer s_id = Integer.valueOf(subjectId);
		List<SCQuestion> list = scQuestionDao.getSCQuestionsBySub(s_id);

		return list;
	}

	@Override
	public List<MCQuestion> getAllMCQuestions(String subjectId) {
		Integer s_id = Integer.valueOf(subjectId);
		List<MCQuestion> list = mcQuestionDao.getMCQuestionsBySub(s_id);
		return list;
	}

	@Override
	public List<TFQuestion> getAllTFQuestions(String subjectId) {
		Integer s_id = Integer.valueOf(subjectId);
		List<TFQuestion> list = tfQuestionDao.getTFQuestionsBySub(s_id);

		return list;
	}

	@Override
	public List<FBQuestion> getAllFBQuestions(String subjectId) {
		Integer s_id = Integer.valueOf(subjectId);
		List<FBQuestion> list = fbQuestionDao.getFBQuestionsBySub(s_id);
		return list;
	}

	@Override
	public List<QAQuestion> getAllQAQuestions(String subjectId) {
		Integer s_id = Integer.valueOf(subjectId);
		List<QAQuestion> list = qaQuestionDao.getQAQuestionsBySub(s_id);

		return list;
	}

	@Override
	public boolean deleteSCQuestion(String id) {
		Integer sc_id = Integer.valueOf(id);

		if (scQuestionDao.deleteById(sc_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteQAQuestion(String id) {
		Integer qa_id = Integer.valueOf(id);

		if (qaQuestionDao.deleteById(qa_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFBQuestion(String id) {
		Integer fb_id = Integer.valueOf(id);
		if (fbQuestionDao.deleteById(fb_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTFQuestion(String id) {
		Integer tf_id = Integer.valueOf(id);
		if (tfQuestionDao.deleteById(tf_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMCQuestion(String id) {
		Integer mc_id = Integer.valueOf(id);
		if (mcQuestionDao.deleteById(mc_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateQAQuestion(String id) {
		Integer qa_id = Integer.valueOf(id);
		if (qaQuestionDao.updateById(qa_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFBQuestion(String id) {
		Integer fb_id = Integer.valueOf(id);
		if (fbQuestionDao.updateById(fb_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTFQuestion(String id) {
		Integer tf_id = Integer.valueOf(id);
		if (tfQuestionDao.updateById(tf_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMCQuestion(String id) {
		Integer mc_id = Integer.valueOf(id);
		if (mcQuestionDao.updateById(mc_id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public SCQuestion selectSCQuestionById(String id) {
		Integer sc_id = Integer.valueOf(id);

		SCQuestion scQuestion = (SCQuestion) scQuestionDao.selectById(sc_id);
		return scQuestion;
	}

	@Override
	public MCQuestion selectMCQuestionById(String id) {
		Integer mc_id = Integer.valueOf(id);
		MCQuestion mcQuestion = mcQuestionDao.selectById(mc_id);
		return null;
	}

	@Override
	public TFQuestion selectTFQuestionById(String id) {
		Integer sc_id = Integer.valueOf(id);
		return null;
	}

	@Override
	public FBQuestion selectFBQuestionById(String id) {
		Integer sc_id = Integer.valueOf(id);
		return null;
	}

	@Override
	public QAQuestion selectQAQuestionById(String id) {
		Integer sc_id = Integer.valueOf(id);
		return null;
	}

	@Override
	public boolean updateSCQuestion(SCQuestionData scQuestionData) {
		Integer subject = scQuestionData.getSc_subject();
		String opint = scQuestionData.getSc_point();
		String stem = scQuestionData.getSc_stem();
		String option = scQuestionData.getSc_option();
		String answer = scQuestionData.getSc_answer();
		String analysis = scQuestionData.getSc_analysis();
		Integer c_id = scQuestionData.getSc_c_id();
		Integer ct_id = scQuestionData.getSc_ct_id();
		Integer level = scQuestionData.getSc_level();
		String username = "admin";
		SCQuestion scQuestion = new SCQuestion(subject, opint, stem, option, answer, analysis, username, c_id, ct_id,
				level);
		if (scQuestionDao.updateSCQuestion(scQuestion) > 0) {
			return false;
		}
		return false;
	}

	@Override
	public Map<String, QuestionLevelNumber> countQuestionLevelNumber(List<Integer> chapterIdList) {
		Map<String, QuestionLevelNumber> questionLevelNumber = new HashMap<String, QuestionLevelNumber>();
		// 根据章节id查询出各种类型的题目信息
		List<SCQuestion> scQuestionList = scQuestionDao.getSCQuestionByChapterId(chapterIdList);
		List<MCQuestion> mcQuestionList = mcQuestionDao.getMCQuestionByChapterId(chapterIdList);
		List<TFQuestion> tfQuestionList = tfQuestionDao.getTFQuestionByChapterId(chapterIdList);
		List<FBQuestion> fbQuestionList = fbQuestionDao.getFBQuestionByChapterId(chapterIdList);
		List<QAQuestion> qaQuestionList = qaQuestionDao.getQAQuestionByChapterId(chapterIdList);
		// 统计各种题目的不同等级的数量
		// 单选题
		QuestionLevelNumber scNumber = new QuestionLevelNumber();
		int level1 = 0;
		int level2 = 0;
		int level3 = 0;
		int level4 = 0;
		for (SCQuestion scQuestion : scQuestionList) {
			int level = scQuestion.getSc_level();
			if (level == 1) {
				level1++;
			} else if (level == 2) {
				level2++;
			} else if (level == 3) {
				level3++;
			} else {
				level4++;
			}
		}
		scNumber.setLevel1(level1);
		scNumber.setLevel2(level2);
		scNumber.setLevel3(level3);
		scNumber.setLevel4(level4);
		questionLevelNumber.put("scQuestionNumber", scNumber);
		
		// 多选题
		QuestionLevelNumber mcNumber = new QuestionLevelNumber();
		level1 = 0;
		level2 = 0;
		level3 = 0;
		level4 = 0;
		for (MCQuestion mcQuestion : mcQuestionList) {
			int level = mcQuestion.getMc_level();
			if (level == 1) {
				level1++;
			} else if (level == 2) {
				level2++;
			} else if (level == 3) {
				level3++;
			} else {
				level4++;
			}
		}
		mcNumber.setLevel1(level1);
		mcNumber.setLevel2(level2);
		mcNumber.setLevel3(level3);
		mcNumber.setLevel4(level4);
		questionLevelNumber.put("mcQuestionNumber", mcNumber);

		// 判断题
		QuestionLevelNumber tfNumber = new QuestionLevelNumber();
		level1 = 0;
		level2 = 0;
		level3 = 0;
		level4 = 0;
		for (TFQuestion tfQuestion : tfQuestionList) {
			int level = tfQuestion.getTf_level();
			if (level == 1) {
				level1++;
			} else if (level == 2) {
				level2++;
			} else if (level == 3) {
				level3++;
			} else {
				level4++;
			}
		}
		tfNumber.setLevel1(level1);
		tfNumber.setLevel2(level2);
		tfNumber.setLevel3(level3);
		tfNumber.setLevel4(level4);
		questionLevelNumber.put("tfQuestionNumber", tfNumber);

		// 填空题
		QuestionLevelNumber fbNumber = new QuestionLevelNumber();
		level1 = 0;
		level2 = 0;
		level3 = 0;
		level4 = 0;
		for (FBQuestion fbQuestion : fbQuestionList) {
			int level = fbQuestion.getFb_level();
			if (level == 1) {
				level1++;
			} else if (level == 2) {
				level2++;
			} else if (level == 3) {
				level3++;
			} else {
				level4++;
			}
		}
		fbNumber.setLevel1(level1);
		fbNumber.setLevel2(level2);
		fbNumber.setLevel3(level3);
		fbNumber.setLevel4(level4);
		questionLevelNumber.put("fbQuestionNumber", fbNumber);

		// 简答题
		QuestionLevelNumber qaNumber = new QuestionLevelNumber();
		level1 = 0;
		level2 = 0;
		level3 = 0;
		level4 = 0;
		for (QAQuestion qaQuestion : qaQuestionList) {
			int level = qaQuestion.getQa_level();
			if (level == 1) {
				level1++;
			} else if (level == 2) {
				level2++;
			} else if (level == 3) {
				level3++;
			} else {
				level4++;
			}
		}
		qaNumber.setLevel1(level1);
		qaNumber.setLevel2(level2);
		qaNumber.setLevel3(level3);
		qaNumber.setLevel4(level4);
		questionLevelNumber.put("qaQuestionNumber", qaNumber);
		return questionLevelNumber;
	}

	@Override
	public int getQuestionsNum() {
		
		int scNum=scQuestionDao.getScQuestionsNum();
		int mcNum=mcQuestionDao.getMcQuestionsNum();
		int qaNum=qaQuestionDao.getQaQuestionsNum();
		int tfNum=tfQuestionDao.getTFQuestionsNum();
		int fbNum=fbQuestionDao.getFbQuestionsNum();
		int total=scNum+mcNum+qaNum+tfNum+fbNum;
		return total;
	}

	@Override
	public int getTestPaperNum() {
		
		return testPaperDao.getTestPaperNum();
	}

	@Override
	public int getUserNum() {
		
		return teacherDao.getTeachersNum();
	}
}
