package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.FBQuestionDao;
import com.test.dao.MCQuestionDao;
import com.test.dao.QAQuestionDao;
import com.test.dao.SCQuestionDao;
import com.test.dao.TFQuestionDao;
import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.po.TestPaper;
import com.test.po.TestPaperView;
import com.test.pojo.MCQuestionView;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.SCQuestionView;
import com.test.pojo.TestPaperData;
import com.test.service.TestPaperService;

/**
 * @author Another
 *
 */
@Service
@Transactional
public class TestPaperServiceImpl implements TestPaperService {

	@Autowired
	private SCQuestionDao scQuestionDao;
	@Autowired
	private MCQuestionDao mcQuestionDao;
	@Autowired
	private TFQuestionDao tfQuestionDao;
	@Autowired
	private FBQuestionDao fbQuestionDao;
	@Autowired
	private QAQuestionDao qaQuestionDao;

	@Override
	public TestPaperView randomCreateTestPaper(TestPaperData testPaperData) {
		TestPaperView testPaperView = new TestPaperView();
		// 章节id
		String[] chapterIds = testPaperData.getChapterIds();
		List<Integer> chapterIdList = new ArrayList<Integer>();
		for (String id : chapterIds) {
			chapterIdList.add(Integer.parseInt(id));
		}
		// 获取不同类型的题目
		QuestionLevelNumber scQuestionLevelNumber = testPaperData.getScNumber();
		QuestionLevelNumber mcQuestionLevelNumber = testPaperData.getMcNumber();
		QuestionLevelNumber tfQuestionLevelNumber = testPaperData.getTfNumber();
		QuestionLevelNumber fbQuestionLevelNumber = testPaperData.getFbNumber();
		QuestionLevelNumber qaQuestionLevelNumber = testPaperData.getQaNumber();
		// 将单选题列表转化单选题视图
		List<SCQuestion> scQuestionList = scQuestionDao.getSCQuestionByChapterIdAndLevelRandom(chapterIdList,
				scQuestionLevelNumber);
		List<SCQuestionView> scQuestionViewList = new ArrayList<SCQuestionView>();
		for (SCQuestion scQuestion : scQuestionList) {
			scQuestionViewList.add(new SCQuestionView(scQuestion));
		}

		// 将多选题列表转化为多选题视图
		List<MCQuestion> mcQuestionList = mcQuestionDao.getMCQuestionByChapterIdAndLevelRandom(chapterIdList,
				mcQuestionLevelNumber);
		List<MCQuestionView> mcQuestionViewList = new ArrayList<MCQuestionView>();
		for (MCQuestion mcQuestion : mcQuestionList) {
			mcQuestionViewList.add(new MCQuestionView(mcQuestion));
		}
		List<TFQuestion> tfQuestionList = tfQuestionDao.getTFQuestionByChapterIdAndLevelRandom(chapterIdList,
				tfQuestionLevelNumber);
		List<FBQuestion> fbQuestionList = fbQuestionDao.getFBQuestionByChapterIdAndLevelRandom(chapterIdList,
				fbQuestionLevelNumber);
		List<QAQuestion> qaQuestionList = qaQuestionDao.getQAQuestionByChapterIdAndLevelRandom(chapterIdList,
				qaQuestionLevelNumber);

		testPaperView.setScQuestions(scQuestionViewList);
		testPaperView.setMcQuestions(mcQuestionViewList);
		testPaperView.setTfQuestions(tfQuestionList);
		testPaperView.setFbQuestions(fbQuestionList);
		testPaperView.setQaQuestion(qaQuestionList);
		// 原有信息回代
		testPaperView.setTpName(testPaperData.getTpName());
		testPaperView.setTpIllustrate(testPaperData.getTpIllustrate());
		testPaperView.setTpTerm(testPaperData.getTpTerm());
		testPaperView.setTpClass(testPaperData.getTpClass());

		return testPaperView;
	}

	@Override
	public int insertTestPaper(TestPaper testPaper) {
		return 0;
	}

}
