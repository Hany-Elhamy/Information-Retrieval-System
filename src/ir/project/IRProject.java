
package ir.project;
import java.io.*;
import java.util.*;



public class IRProject {
    
    

   
    public static void main(String[] args) {
        
        int c=0,c1=0,c2=0,i=1;
        int b;
        boolean flag,flag2,exist;
        int j=0;
        
        
        String[] x,y,l;
       
        String f,w="";
          ArrayList<Integer> index = new ArrayList<Integer>();
          ArrayList<String> docs = new ArrayList<String>();
           ArrayList<String[]> z2 = new ArrayList<String[]>();
         
        String[] s={"for","or","nor","and","if","to","in","a","an","from","it","is","are","am","of","on","the","be"};
      
       
       
        
        
       //---------------------------------------reading files------------------------------------------------
        for(i=1;i<=4;i++)
            
        {
            
        //-------------------------------------reading a file------------------------------------------------------    
                    try
                    {
                            File fr=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\"+i+".txt");
                            
                              Scanner r=new Scanner(fr);
                              
                              while(r.hasNextLine())
                              {
        //-------------------------------------modifying lines in a file------------------------------------------------------  
                                        x=r.nextLine().replaceAll("[(),'.\":]", "").split(" ");
                                        
        //-------------------------------------comparing words in a line to stop words------------------------------------------------------  
                                  for(j=0;j<x.length;j++)
                                  { 
                                      
                                                flag=false;

                                                FileWriter fw=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\result.txt",true);

                                               for(int z=0;z<s.length;z++)
                                               {
                                                   if(x[j].toLowerCase().equals(s[z].toLowerCase()))
                                                   {
                                                       flag=true;
                                                   }
                                               }
                                               
                                               
                                               if(flag!=true)
                                               {
                                                   
        //-------------------------------------comparing words to existing words in result file------------------------------------------------------                                             
                                                   
                                                   flag2=false;
                                                   
                                                   File fr2=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\result.txt");
                    
                                                   Scanner r2=new Scanner(fr2);
                                                   
                                                   
                                                   while(r2.hasNextLine())
                                                   {
                                                       if(x[j].toLowerCase().equals(r2.nextLine().toLowerCase()))
                                                       {flag2=true;}
                                                   } 
                                                   
        //-------------------------------------inserting words after putting them to lower case------------------------------------------------------                                             
                                                   if(flag2!=true)
                                                   {
                                                       fw.write(x[j].toLowerCase()+"\n");
                                                       fw.close();
                                                   }
                                                   

                                                    
                                               }
                                  }

                              }




                   }
                    catch (IOException e) 
                       {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                       }
        }

        
      //--------------------------------------------------------------------------------------------
      //------------------------------------indexing--------------------------------------------------------
        
       //-------------------------------------reading from the results file------------------------------------------------------  
      try
         {
                    File fr2=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\result.txt");
                    
                    Scanner r=new Scanner(fr2);  
                    
                    while(r.hasNextLine())
                    {
                                f=r.nextLine(); 
                                FileWriter fw2=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt",true);
                                 fw2.write('<'+f+";");
                                 fw2.close();
                               // System.out.println("------------------"+f+"-----------------------------------");
        
        //-------------------------------------reading from the  files------------------------------------------------------                          
                                for(i=1;i<=4;i++)
                                {
                                   
                                            File fr=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\"+i+".txt");
                                        
        //-------------------------------------putting all lines of a file in one string------------------------------------------------------                                      
                                        
                                          Scanner r2=new Scanner(fr);
                                        
                                         while(r2.hasNextLine())
                                         {
                                                    
                                         
                                                    w=w.concat(r2.nextLine());  
                                             
                                         }
                                                 //System.out.println(w);
                                                 
        //-------------------------------------putting the string in a string array------------------------------------------------------  
                                                 
                                                 
                                         l=w.replaceAll("[(),'.\":]", "").toLowerCase().split(" ");
                                         w="";
                                         exist=false;
                                         
        //-------------------------------------compare result word to  the other words in the array------------------------------------------------------                                   
                                         
                                         for(int g=0;g<l.length;g++)
                                         { 
                                             //System.out.println("array is "+l[g]+" and index num. is "+g);
                                             if(f.equals(l[g]))
                                                     {
                                                        
                                                         index.add(g);
                                                   
                                                         exist=true;
                                                         
                                                     }
                                             

                                         } //System.out.println(exist+" "+f);
//---------------------------------------------positional indexing------------------------------------------------------------------------------------                                         
                                         if(exist)
                                         {
                                             c++;
                                             fw2=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt",true);
                                             fw2.write("doc" +i+':');
                                             fw2.close();
                                            for (Integer g : index) {
      
                                                 fw2=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt",true);
                                                 fw2.write(g.toString()+',');
                                                 fw2.close();
                                             }
                                             fw2=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt",true);
                                             fw2.write(";  ");
                                             fw2.close();
                                             
                                           
                                         
                                         }
                                           index.clear();
                                         
                                }
                    fw2=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt",true);
                    fw2.write(">"+"DF:"+c+ "\n\n"); 
                    fw2.close();
                     c=0;
                                
                     } 
                    
                    
                    String k="";
      while(!k.equals("-1"))
      {
      Scanner read=new Scanner(System.in);
      System.out.print("please enter query or -1 to exit:");
      k=read.nextLine();
      String[]n=k.toLowerCase().split(" ");
      
      for(String m:n)
      {
          System.out.println("---------------------"+m+"---------------------");
          File f2=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\final_result.txt");
          Scanner v=new Scanner(f2);          
          while(v.hasNextLine())
          {
              String p=v.nextLine();
            
              if(p.contains(m))
              {
                 FileWriter fw3=new FileWriter("C:\\Users\\20100\\Desktop\\IR-project\\files\\Tresult.txt",true);
                    fw3.write(p+"\n"); 
                    fw3.close();
                  
                 // System.out.println(p+"after loop");
                 break;
                  
                  
              }
              
              
          }
          
          
      }
      
            int A=1;

      
          for(A=1;A<=10;A++)
      {
          File f3=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\Tresult.txt");
      Scanner u=new Scanner(f3);
          String o="doc"+A;
          
          
      c1=c2=0;
      while(u.hasNextLine())
      {
          c1++;
      String D=u.nextLine();
      
      
      if(D.contains(o))
      {
          c2++;
      }
      }
//      System.out.println(c1);
//      System.out.println(c2);
         if(c1==c2)
         {
            docs.add(o); 
         }
      
      }
      for(String O:docs)
      {
          File f3=new File("C:\\Users\\20100\\Desktop\\IR-project\\files\\Tresult.txt");
      Scanner u=new Scanner(f3);
      while(u.hasNextLine())
      {
          
          String D="";
          String []D2;
          String d=u.nextLine();
          
          
           D=d.substring(d.indexOf(O));
           
           D2=D.substring(D.indexOf(O)+5,D.indexOf(';')).split(",");
           z2.add(D2);
           
           
           
           
      
      }
      for( int i2=0;i2<z2.size();i2++)
          
      {
          for(int i3=0;i3<z2.get(i2).length;i3++)
          {
             System.out.println("the array number is "+ z2.get(i2)+" and the element is "+z2.get(i2)[i3]); 
          }
//          System.out.println(i2);
      }
      z2.clear();
          
      }
       
      
      

      
      
      }
      
      
                           




             }
            catch (IOException e) 
            {
                System.out.println("An error occurred while indexing.");
                e.printStackTrace();
                
            }
      
      
        
        
        
        
    }
    
}
