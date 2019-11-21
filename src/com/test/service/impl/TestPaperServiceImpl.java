package com.test.service.impl;

import java.util.ArrayList;
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
import com.test.dao.TestPaperDao;
import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.po.TestPaper;
import com.test.po.TestPaperView;
import com.test.pojo.FillInTheBlank;
import com.test.pojo.MCQuestionView;
import com.test.pojo.MultipleChoice;
import com.test.pojo.QuestionAndAnswer;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.SCQuestionView;
import com.test.pojo.SingleChoice;
import com.test.pojo.TestPaperData;
import com.test.pojo.TrueOrFalse;
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
		
		testPaperView.setTpId(testPaper.getTp_id());
		testPaperView.setTpName(testPaper.getTp_name());
		testPaperView.setTpCreateName(testPaper.getTp_t_name());
		testPaperView.setTpClass(testPaper.getTp_class());
		testPaperView.setTpIllustrate(testPaper.getTp_illustrate());
		testPaperView.setTpTerm(testPaper.getTp_term());
		testPaperView.setTpMajor(testPaper.getTp_major());

		String[] scIds = testPaper.getTp_sc_id().split("@@");
		String[] mcIds = testPaper.getTp_mc_id().split("@@");
		String[] tfIds = testPaper.getTp_tf_id().split("@@");
		String[] fbIds = testPaper.getTp_fb_id().split("@@");
		String[] qaIds = testPaper.getTp_qa_id().split("@@");
		//System.out.println("scIds:"+scIds.length+"mcIds:"+mcIds.length+"tfIds:"+tfIds.length+"fbIds:"+fbIds.length+"qaIds:"+qaIds.length);
		List<SCQuestion> scQuestionList = new ArrayList<SCQuestion>();
		for (String id : scIds) {
			if(scIds.length>1) {
				//System.out.println(id);
				SCQuestion sc=scQuestionDao.selectById(Integer.parseInt(id));
			//	System.out.println(sc.toString());
				scQuestionList.add(sc);
			}
		}
		List<MCQuestion> mcQuestionList = new ArrayList<MCQuestion>();
		for (String id : mcIds) {
			if(mcIds.length>1) {
				mcQuestionList.add(mcQuestionDao.selectById(Integer.parseInt(id)));   
			}
		}
		List<TFQuestion> tfQuestionList = new ArrayList<TFQuestion>();
		for (String id : tfIds) {
			if(tfIds.length>1) {
		
				tfQuestionList.add(tfQuestionDao.selectTFQuestionById(Integer.parseInt(id)));
			}
		}
		List<FBQuestion> fbQuestionList = new ArrayList<FBQuestion>();
		for (String id : fbIds) {
			if(fbIds.length>1) {
				fbQuestionList.add(fbQuestionDao.selectFBQuestionById(Integer.parseInt(id)));
			}
		}
		List<QAQuestion> qaQuestionList = new ArrayList<QAQuestion>();
		for (String id : qaIds) {
			if(qaIds.length>1) {
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
		return testPaperView;
	}

	@Override
	public Map<String, Object> dataFill(TestPaper testPaper) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("schoolName", "中原工学院");
		dataMap.put("startYear", "2016");
		dataMap.put("endYear", "2017");
		dataMap.put("semester", testPaper.getTp_term());
		dataMap.put("class", testPaper.getTp_class());
		// 拼接添加是期中考试还是期末考试
		dataMap.put("testPaperName", "计算机网络 期末试卷");
		dataMap.put("major", testPaper.getTp_major());
		dataMap.put("marker", testPaper.getTp_t_name());
		String[] scIds = testPaper.getTp_sc_id().split("@@");
		String[] mcIds = testPaper.getTp_mc_id().split("@@");
		String[] tfIds = testPaper.getTp_tf_id().split("@@");
		String[] fbIds = testPaper.getTp_fb_id().split("@@");
		String[] qaIds = testPaper.getTp_qa_id().split("@@");
		// 将数据库对应的POJO转化为freemarker模板中的对象
		// 单选题转化
		List<SingleChoice> singleChoiceList = new ArrayList<SingleChoice>();
		List<SCQuestion> scQuestionList = new ArrayList<SCQuestion>();
		for (String id : scIds) {
			if (scIds.length > 1) {
				scQuestionList.add(scQuestionDao.selectById(Integer.parseInt(id)));
			}
		}
		for (SCQuestion scQuestion : scQuestionList) {
			SingleChoice singleChoice = new SingleChoice();
			singleChoice.setContent(scQuestion.getSc_stem());
			String[] options = scQuestion.getSc_option().split("@@");
			singleChoice.setOptionA(options[0].substring(options[0].indexOf(".") + 1, options[0].length()));
			singleChoice.setOptionB(options[1].substring(options[1].indexOf(".") + 1, options[1].length()));
			singleChoice.setOptionC(options[2].substring(options[2].indexOf(".") + 1, options[2].length()));
			singleChoice.setOptionD(options[3].substring(options[3].indexOf(".") + 1, options[3].length()));
			singleChoiceList.add(singleChoice);
		}
		// 多选题转化
		List<MultipleChoice> multipleChoiceList = new ArrayList<MultipleChoice>();
		List<MCQuestion> mcQuestionList = new ArrayList<MCQuestion>();
		for (String id : mcIds) {
			if (mcIds.length > 1) {
				mcQuestionList.add(mcQuestionDao.selectById(Integer.parseInt(id)));
			}
		}
		for (MCQuestion mcQuestion : mcQuestionList) {
			MultipleChoice multipleChoice = new MultipleChoice();
			multipleChoice.setContent(mcQuestion.getMc_stem());
			String[] options = mcQuestion.getMc_option().split("@@");
			multipleChoice.setOptionA(options[0].substring(options[0].indexOf(".") + 1, options[0].length()));
			multipleChoice.setOptionB(options[1].substring(options[1].indexOf(".") + 1, options[1].length()));
			multipleChoice.setOptionC(options[2].substring(options[2].indexOf(".") + 1, options[2].length()));
			multipleChoice.setOptionD(options[3].substring(options[3].indexOf(".") + 1, options[3].length()));
			multipleChoiceList.add(multipleChoice);
		}
		// 判断题
		List<TrueOrFalse> trueOrFalseList = new ArrayList<TrueOrFalse>();
		List<TFQuestion> tfQuestionList = new ArrayList<TFQuestion>();
		for (String id : tfIds) {
			if (tfIds.length > 1) {
				tfQuestionList.add(tfQuestionDao.selectTFQuestionById(Integer.parseInt(id)));
			}
		}
		for (TFQuestion tfQuestion : tfQuestionList) {
			TrueOrFalse trueOrFalse = new TrueOrFalse();
			trueOrFalse.setContent(tfQuestion.getTf_stem());
			trueOrFalseList.add(trueOrFalse);
		}
		// 填空题
		List<FillInTheBlank> fillInTheBlankList = new ArrayList<FillInTheBlank>();
		List<FBQuestion> fbQuestionList = new ArrayList<FBQuestion>();
		for (String id : fbIds) {
			if (fbIds.length > 1) {
				fbQuestionList.add(fbQuestionDao.selectFBQuestionById(Integer.parseInt(id)));
			}
		}
		for (FBQuestion fbQuestion : fbQuestionList) {
			FillInTheBlank fillInTheBlank = new FillInTheBlank();
			fillInTheBlank.setContent(fbQuestion.getFb_stem());
			fillInTheBlankList.add(fillInTheBlank);
		}
		// 问答题
		List<QuestionAndAnswer> questionAndAnswerList = new ArrayList<QuestionAndAnswer>();
		List<QAQuestion> qaQuestionList = new ArrayList<QAQuestion>();
		for (String id : qaIds) {
			if (qaIds.length > 1) {
				qaQuestionList.add(qaQuestionDao.selectQAQuestionById(Integer.parseInt(id)));
			}
		}
		for (QAQuestion qaQuestion : qaQuestionList) {
			QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
			questionAndAnswer.setContent(qaQuestion.getQa_stem());
			questionAndAnswerList.add(questionAndAnswer);
		}
		dataMap.put("singleChoiceList", singleChoiceList);
		dataMap.put("multipleChoiceList", multipleChoiceList);
		dataMap.put("fillInTheBlankList", fillInTheBlankList);
		dataMap.put("trueOrFalseList", trueOrFalseList);
		dataMap.put("questionAndAnswerList", questionAndAnswerList);
		return dataMap;
	}

}
