
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Character.isWhitespace;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author farid
 */
public class readR {
	int nb,tb=9;
int i = 0;
String Vt[]={"-", "+", "/", "*", "Integer", "Identifier", "(", ")", "#"};
String Table[][];
 public void calcu() {
 try {
 RandomAccessFile file = new RandomAccessFile("C:\\Users\\Afak\\Desktop\\framecompl\\reader.txt", "r");
 String str;
 
 while ((str = file.readLine()) != null) {
 //System.out.println(i +"   " + str);
    i++;
 }
 nb = i ;
 file.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 
String [] tblex;
 public void tblx () {
     try {
    RandomAccessFile file = new RandomAccessFile("C:\\Users\\Afak\\Desktop\\framecompl\\reader.txt", "r");
    String st;
     tblex  = new String [nb];
    i=0; 
    while (i<nb) {
          st = file.readLine();
          tblex[i] = st; 
          i++;
        }
    file.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
  
    
        
 }
 
 public void affichex() {
     int i=0;
     while (i<nb){
           System.out.println(tblex[i]);
           i++;
        }
 }
 
 String [][] Tab;
 public void Remplir()
    {
   //hada ch7al mn star fl fichier
     Tab=new String[nb][];
    int i;
    int j=0;
    int m=0;
    String  c;
    while(j<nb)
    {
       
        String expression=tblex[m];// w hadi dirha d stor ta3 fichier
        int n=expression.length();
        int s=expression.indexOf("=");
        i=2;
        int k=s;
        c="";
        while (k<n)
        {
            if(expression.charAt(k)=='|')
                i++;
           // c=c+expression.charAt(k);
            k++;
        }
        Tab[j]=new String[i];
        for(k=0;k<s;k++)
           c=c+expression.charAt(k);

        k=0;
        Tab[j][k]=c;
        k++;
        c="";
        char b;
        s=s+1;
        while(s<n)
        {
          b=expression.charAt(s);
          if(b=='|'||s==n-1)  
          {
              Tab[j][k]=c;
              k++;
              c="";
              s++;
          }
          else
          {
              c=c+expression.charAt(s);
              s++;
          }


        }
        j++;
        m++;
    }
    
    }
    // mna whbt affichage
    public void affichtab(){
        
   
    int i=0;
    int j;
    int m;
    while(i<nb)
    {
        System.out.println("LA Ligne "+ (i+1));
        j=0;
        m=Tab[i].length;
      //  System.out.println("m " + m);
        while (j<m)
        {
            System.out.print(Tab[i][j]+"\t");
            j++;
        }
        i++;
        System.out.println("\n");
    }
    }
    String [] Vn;
    public void  RempVn() {
        Vn  = new String [nb];
        int i=0;
        while (i<nb){
            Vn[i]= Tab[i][0];
           // System.out.println(Vn[i]);
            i++;
        }
        
    }
    
    //htha hadi f readR.java
    

     public String First(int i,String Tab[][],boolean b,boolean vr,int q,String ss)
    {
        String first="";
        int j=1,n=nb;
        String S;
        int mn;       
        int kx=0;
        mn=Tab[i].length;
        while(j<mn)
        {
            S=Tab[i][j];
			if(b){
				ss=S;
			}
            if( (S.equals("EPSILO")) && ( b==true )) {
                first=first+S;
				
            }
                
            else
            {
                if (S.equals("EPSILO") && ( b!=true )) {
                    // first = first + Follow(Tab[i][0],Tab);
                     j++;
                  
                }
                else{
                 
                int k=0;
                int m=S.length();
                String temp="";
                boolean end=true;
                //hada yhaz lkalma
                while ( (k<m) && (end)) 
                {
                    if(isWhitespace(S.charAt(k))&& temp!=""){
                        end=false ; 
                      k=m;
                    }
                      
                    else
                    {
                        if(S.charAt(k)==' '){
                             k++;
                        }
                          
                        else
                        {
                            temp=temp+S.charAt(k);
                            k++;
                        }
                     }
                    
                }
                
                    k=i+1; //ysoti hadak espace
                    kx=k;
                
                    boolean a=false;
                    //hna ytasti ida Vn
                    while(k<n && !a)
                    {
                       if(temp.equals(Vn[k])){
                           a=true;
                       }
                            
                        else {
                           k++; 
                       } 
                    }
                    
                    if(a==false)
                    {  
                      first=first+temp+" ";
					  if(vr){
						  int z=0;
					  while(!temp.equals(Vt[z])){
						  z++;
					  }
						Table[q][z] = ss ;  
					  }
					  
					  
					}
                    else
                    {
                         first = first + First(k,Tab,false,true,q,ss);
                    }
                     
            }
            }
		/*	
			String tst = first;
			int ie=0, co = tst.length();
			while(ie<co){
				
				
				
				
				
			}
			-*/
			
			
			
            j++;
            }
       
            //System.out.println("first ta3na freturn : "+first);
            return first ;
            
            
    }

    public String Follow(String follow,String Tab[][]){
       String str="";
       int i=0;
       if (follow.equals(Vn[0])) str = str + " # ";
       int n = nb;
       boolean ex=false;
          while (i<n) {
             int j;
             int k=1;
             j=Tab[i].length;
             while(k<j){
                 String s = Tab[i][k] + " ";
                 int sn = s.length();
                 int si;
                 ex = s.contains(follow);
                 if (ex) {
    //                 System.out.println( follow +"  tab = "+ s + " ex = "+ ex);
                     si = s.indexOf(follow) + follow.length() - 1;
    //                 System.out.println(" dimari fi : " + s.indexOf(follow) + "[" + s.charAt(s.indexOf(follow)) + "]" + " tkhlas lkalma fi : " + si +"[" + s.charAt(si) + "]" );
                    String next="";
                    boolean b3=true;
                    si++;
                    
                     while ( (si<sn) && (b3)){
                        if( (isWhitespace(s.charAt(si))) && (next!="") ){
                            b3=false ;
                            boolean b4=false;
                            int kk=0;
    //                                System.out.println("\n next ===== " + next );
                            while ((kk<n) && !b4 ){
                                if(next.equals(Vn[kk])){
									
									b4=true;
                                }
                                else kk++;
                            }
                            if (b4){
								String fr, frf;
								frf = First(kk,Tab,false,false,kk," ");
								fr = First(kk,Tab,true,false,kk," ");
								if (fr.contains("EPSILO")){
									frf = frf + Follow(next,Tab);
									
								}
								
									
                                str = str + " " +frf ;
                            }
                            else {
                                str = str +" " + next;
                            }
                          
                        }

                        else
                        {
                            if(s.charAt(si)==' '){
                                 si++;
                            }

                            else
                            {
								 next=next+s.charAt(si);
                                    si++;
                            }
                         }
                    
                    }
					 
					 if (next == ""){
						 String tst ;
						 tst = Tab[i][0];
						 if (tst.equals(follow)) {
	//						 System.out.println("\n hna next w ex kif kif  ");
						 }
						 else{
							 
							 str = str + " " + Follow(tst,Tab);
						 }
					 }
					 
                 
                 }
                // System.out.println(" la tay ta3 follow " + follow.length() + " la tay ta3 s " + sn );
				 
             k++;
             }
              
             i++;
            }
	//	  System.out.println("\n str === " + str);
                  
        return str;
    }
    

    void CreateT(int a,int b){
		Table=new String [a][b];
		int ww,zz;
		for (ww=0;ww<nb;ww++){
			for(zz=0;zz<tb;zz++){
				Table[ww][zz] = "null" ; 
			}
		}
	}
	
	
}
