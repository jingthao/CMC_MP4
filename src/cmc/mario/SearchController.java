package cmc.mario;
/**
 * File: SearchController.java
 * author Jing Thao | Mario Party 4
 * @version March 19, 2017
 */

import java.util.*;

/**
 * SearchController Class which helps search universities 
 * which meet the requirements from user extends userFuncController
 * 
 * @author Mario Party 4: Jing Thao and Kalila Moua
 * @version March 19, 2017
 */
public class SearchController {
  private DBController dbControl;
  /*
   * Constructor of the class: Inherited from super class: AccountController
   */
  public SearchController() {
    this.dbControl = new DBController();
  }
  
  /**
   * Searches for schools with the conditions given -Kalila 
   * 
   * @param schoolName the user gives   
   * @param state the user gives 
   * @param location the user gives 
   * @param control the user gives 
   * @param numOfStuStart the number of students starting range number
   * @param numOfStuEnd the number of students ending range number
   * @param perFemStart the percentage of students who are female starting range number
   * @param perFemEnd the percentage of students who are female ending range number
   * @param satVerbalStart the starting range for SAT verbal score
   * @param satVerbalEnd the ending range for SAT verbal score
   * @param satMathStart the starting range for SAT math score
   * @param satMathEnd the ending range for SAT math score
   * @param priceStart the starting range for price/expenses
   * @param priceEnd the ending range for price/expenses
   * @param finAidStart the starting range for financial aid percentage
   * @param finAidEnd the ending range for financial aid percentage
   * @param numOfAppStart the user gives 
   * @param perAdmitStart the starting range for admitted students percentage
   * @param perAdmitEnd the ending range for admitted students percentage
   * @param perEnrollStart the starting range for enrolled students percentage
   * @param perEnrollEnd the ending range for enrolled students percentage
   * @param academicScaleStart the starting range for quality of academics
   * @param academicScaleEnd the ending range for quality of academics
   * @param socialScaleStart the starting range for quality of social
   * @param socialScaleEnd the ending range for quality of social
   * @param lifeScaleStart the starting range for quality of life scale
   * @param lifeScaleEnd the ending range for quality of life scale 
   * @param popMajor an list of popular major or emphases at the university
   */
  public List<University> search(String schoolName, String state, String location, String control, int numOfStuStart, int numOfStuEnd, 
		  double perFemStart,double perFemEnd, int satVerbalStart, int satVerbalEnd, int satMathStart, int satMathEnd, int priceStart, int priceEnd,
		  int finAidStart,int finAidEnd, int numOfAppStart, int numOfAppEnd, double perAdmitStart, double perAdmitEnd, double perEnrollStart, 
		  double perEnrollEnd, int academicScaleStart, int academicScaleEnd, int socialScaleStart, int socialScaleEnd, int lifeScaleStart,
		  int lifeScaleEnd, String[] popMajor){
	  	return dbControl.searchResults(schoolName, state, location, control, numOfStuStart, numOfStuEnd, perFemStart, perFemEnd, satVerbalStart,
	  			satVerbalEnd, satMathStart, satMathEnd, priceStart, priceEnd, finAidStart, finAidEnd, numOfAppStart, numOfAppEnd, perAdmitStart,
	  			perAdmitEnd, perEnrollStart, perEnrollEnd, academicScaleStart, academicScaleEnd, socialScaleStart, socialScaleEnd, lifeScaleStart,
	  			lifeScaleEnd, popMajor);
  }
  /**
   * Gives a list of recommendations for the school that was chosen
   * 
   * @param u the university to be compared to.
   * @return A list of universities
   */
  @SuppressWarnings("null")
public List<University> viewRecommendation(University u){
	  List<University> uniList = dbControl.getUniversities();//dbControl.getUniversities();
	  List<University> uniRecommendList = new ArrayList<University>();
	  while (!(uniList.isEmpty())){
		  for(int i = 0; i < uniList.size(); i++ ){
			University uni = uniList.get(i); 
			
			if(uni.getSatMath() > u.getSatMath()-100 && uni.getSatMath() < u.getSatMath() +100){
				if(uni.getSatVerbal() > u.getSatVerbal()-100 && uni.getSatVerbal() < u.getSatVerbal() +100){
					if(uni.getLifeScale() > u.getLifeScale() -1 && uni.getLifeScale() <uni.getLifeScale() +1){
						if(uni.getSocialScale() > u.getSocialScale() -1 && uni.getSocialScale() <uni.getSocialScale() +1){
							if(uni.getAcademicScale() > u.getAcademicScale() -1 && uni.getAcademicScale() <uni.getAcademicScale() +1){

								uniRecommendList.add(uni);
							}
						}
					}
				
			
	
				}
			}
		  
    
		  
  
		  }
	  }
	return uniRecommendList;  
  }
  
}
