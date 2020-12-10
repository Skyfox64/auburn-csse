   import java.awt.*;

   class GraphicsProgram extends Canvas{
   
      public GraphicsProgram(){
         setSize(720, 1280);
         setBackground(Color.cyan);
      }
   
      public static void main(String[] argS){
      
         //GraphicsProgram class is now a type of canvas
          //since it extends the Canvas class
          //lets instantiate it
         GraphicsProgram GP = new GraphicsProgram();  
      
        //create a new frame to which we will add a canvas
         Frame aFrame = new Frame();
         aFrame.setSize(720, 1280);
        
        //add the canvas
         aFrame.add(GP);
        
         aFrame.setVisible(true);
      }
   
      public void paint(Graphics g){
      
         g.setColor(Color.blue);
         Image img1 = Toolkit.getDefaultToolkit().getImage("cloud.png"); 
         g.drawImage(img1, 20, 20, this); 
      }
   }