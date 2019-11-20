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
import com.test.dao.TestPaperDao;
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
	@Autowired
	private TestPaperDao testPaperDao;

	@Override
	public TestPaper randomCreateTestPaper(TestPaperData testPaperData) {
		TestPaper testPaper = new TestPaper();
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

		List<SCQuestion> scQuestionList = scQuestionDao.getSCQuestionByChapterIdAndLevelRandom(chapterIdList,
				scQuestionLevelNumber);

		List<MCQuestion> mcQuestionList = mcQuestionDao.getMCQuestionByChapterIdAndLevelRandom(chapterIdList,
				mcQuestionLevelNumber);
		List<TFQuestion> tfQuestionList = tfQuestionDao.getTFQuestionByChapterIdAndLevelRandom(chapterIdList,
				tfQuestionLevelNumber);
		List<FBQuestion> fbQuestionList = fbQuestionDao.getFBQuestionByChapterIdAndLevelRandom(chapterIdList,
				fbQuestionLevelNumber);
		List<QAQuestion> qaQuestionList = qaQuestionDao.getQAQuestionByChapterIdAndLevelRandom(chapterIdList,
				qaQuestionLevelNumber);
		StringBuffer scIds = new StringBuffer();
		scQuestionList.stream().forEach(sc -> {
			scIds.append(sc.getSc_id()).append("@@");
		});
		StringBuffer mcIds = new StringBuffer();
		mcQuestionList.stream().forEach(mc -> {
			mcIds.append(mc.getMc_id()).append("@@");
		});
		StringBuffer tfIds = new StringBuffer();
		tfQuestionList.stream().forEach(tf -> {
			mcIds.append(tf.getTf_id()).append("@@");
		});
		StringBuffer fbIds = new StringBuffer();
		fbQuestionList.stream().forEach(fb -> {
			fbIds.append(fb.getFb_id()).append("@@");
		});
		StringBuffer qaIds = new StringBuffer();
		qaQuestionList.stream().forEach(qa -> {
			qaIds.append(qa.getQa_id()).append("@@");
		});
		// 将查询出的不同类型的试题的封装到到testPaper中
		testPaper.setTp_sc_id(scIds.toString());
		testPaper.setTp_mc_id(mcIds.toString());
		testPaper.setTp_tf_id(tfIds.toString());
		testPaper.setTp_fb_id(fbIds.toString());
		testPaper.setTp_qa_id(qaIds.toString());

		testPaper.setTp_name(testPaperData.getTpName());
		testPaper.setTp_class(testPaperData.getTpClass());
		testPaper.setTp_illustrate(testPaperData.getTpIllustrate());
		testPaper.setTp_term(testPaperData.getTpTerm());
		testPaper.setTp_t_name("admin");
		testPaper.setTp_status(0);
		testPaper.setTp_score(testPaperData.getTpScore());
		testPaper.setTp_major(testPaperData.getTpMajor());

		return testPaper;
	}

	@Override
	public int insertTestPaper(TestPaper testPaper) {
		return testPaperDao.insertTestPaper(testPaper);
	}

	@Override
	public TestPaper selectTestPaperById(Integer testPaperId) {
		return testPaperDao.selectTestPaperById(testPaperId);
	}

	@Override
	public TestPaperView convertTestPaper(TestPaper testPaper) {
		TestPaperView testPaperView = new TestPaperView();
		testPaperView.setTpName(testPaper.getTp_name());
		testPaperView.setTpCreateName(testPaper.getTp_t_name());
		testPaperView.setTpClass(testPaper.getTp_class());
		testPaperView.setTpIllustrate(testPaper.getTp_illustrate());
		testPaperView.setTpTerm(testPaper.getTp_term());

		String[] scIds = testPaper.getTp_sc_id().split("@@");
		String[] mcIds = testPaper.getTp_mc_id().split("@@");
		String[] tfIds = testPaper.getTp_tf_id().split("@@");
		String[] fbIds = testPaper.getTp_fb_id().split("@@");
		String[] qaIds = testPaper.getTp_qa_id().split("@@");
		List<SCQuestion> scQuestionList = new ArrayList<SCQuestion>();
		for (String id : scIds) {
			if(scIds.length>0) {
				scQuestionList.add(scQuestionDao.selectById(Integer.parseInt(id)));
			}
		}
		List<MCQuestion> mcQuestionList = new ArrayList<MCQuestion>();
		for (String id : mcIds) {
			if(mcIds.length>0) {
				mcQuestionList.add(mcQuestionDao.selectById(Integer.parseInt(id)));
			}
		}
		List<TFQuestion> tfQuestionList = new ArrayList<TFQuestion>();
		for (String id : tfIds) {
			if(tfIds.length>0) {
				tfQuestionList.add(tfQuestionDao.selectTFQuestionById(Integer.parseInt(id)));
			}
		}
		List<FBQuestion> fbQuestionList = new ArrayList<FBQuestion>();
		for (String id : fbIds) {
			if(fbIds.length>0) {
				fbQuestionList.add(fbQuestionDao.selectFBQuestionById(Integer.parseInt(id)));
			}
		}
		List<QAQuestion> qaQuestionList = new ArrayList<QAQuestion>();
		for (String id : qaIds) {
			if(qaIds.length>0) {
				qaQuestionList.add(qaQuestionDao.selectQAQuestionById(Integer.parseInt(id)));
			}
		}
		// 将单选题列表转化单选题视图
		List<SCQuestionView> scQuestionViewList = new ArrayList<SCQuestionView>();
		for (SCQuestion scQuestion : scQuestionList) {
			scQuestionViewList.add(new SCQuestionView(scQuestion));
		}
		testPaperView.setScQuestions(scQuestionViewList);
		// 将多选题列表转化为多选题视图
		List<MCQuestionView> mcQuestionViewList = new ArrayList<MCQuestionView>();
		for (MCQuestion mcQuestion : mcQuestionList) {
			mcQuestionViewList.add(new MCQuestionView(mcQuestion));
		}
		testPaperView.setMcQuestions(mcQuestionViewList);
		testPaperView.setTfQuestions(tfQuestionList);
		testPaperView.setFbQuestions(fbQuestionList);
		testPaperView.setQaQuestion(qaQuestionList);
		return null;
	}

}
