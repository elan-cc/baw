package com.ruoyi.web.utils;

import com.ruoyi.common.utils.StringUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.ui.ModelMap;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhuhe
 * @date 2022年04月07日 15:49
 */
public class PinYinUtils {
	/**
	 * @param china (字符串 汉字)
	 * @return 汉字转拼音 其它字符不变
	 */
	public static String getPinyin(String china){
		HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
		formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		formart.setVCharType(HanyuPinyinVCharType.WITH_V);
		char[] arrays = china.trim().toCharArray();
		String result = "";
		try {
			for (int i=0;i<arrays.length;i++) {
				char ti = arrays[i];
				//匹配是否是中文
				if(Character.toString(ti).matches("[\\u4e00-\\u9fa5]")){
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(ti,formart);
					result += temp[0];
				}else{
					result += ti;
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 获取汉字串拼音，英文字符不变
	 */
	public static String getFullSpell(String chinese) {
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				try {
					if (null != PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)){
						pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
					} else {
						pybf.append(arr[i]);
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// e.printStackTrace();
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString();
	}
	/**
	 * 将集合数据按照汉字首字母分组排序
	 * @param list
	 */
	public static Map<String, Object> screenManufacturer(List<ModelMap> list) {
		try {
			Collator com = Collator.getInstance(java.util.Locale.CHINA);
			List<String> names = new ArrayList<>();
			for (Map<String, Object> map : list) {
				String name = (String) map.get("city");
				names.add(name);
			}
			// 按字母排序
			Collections.sort(names, com);
			// 输出26个字母
			Map<String, Object> map = new TreeMap<>();
			for (int i = 1; i < 27; i++) {
				String word = String.valueOf((char)(96 + i)).toUpperCase();
				// 循环找出 首字母一样的数据
				List<Map<String, Object>> letter = new ArrayList<>();
				for (Map<String, Object> stringMap : list) {
					String name = (String) stringMap.get("city");
					String pybf = getFullSpell(name);
					String zm = pybf.substring(0, 1);
					if (word.equals(zm)){
						letter.add(stringMap);
					}
				}
				/*if (StringUtils.isNull(letter) || letter.size() == 0){
					// 如果是空跳过
					continue;
				}*/
				map.put(word, letter);
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getPinyin("中国红123"));
	}
}
