import java.io.*;
import minipython.analysis.*;
import minipython.node.*;
import java.util.*;


public class secondVisitor extends DepthFirstAdapter 
{
	private Hashtable symtable;	
	int errorCount = 0;
	secondVisitor(Hashtable symtable) 
	{
		this.symtable = symtable;
	}

//------------------------------------------------------------------------------------------------
	//define type of variable
	public void outACalculateEqStatement(ACalculateEqStatement node)
	{
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		if(getIn(node) == null){
			symtable.put(id,getIn(node.getExpression()));
			setIn(node,symtable.get(id));
		}	
		else {
			String nameL = getIn(node).getClass().getName();
			String nameR = getIn(node.getExpression()).getClass().getName();

			if(nameL != nameR){
				System.out.println("[ " + line + ", " + pos + " ] : Id not defined this way");
				errorCount++;
			}
		}
		

	}
	//define type of matrix
	public void outACalculate2Statement(ACalculate2Statement node){
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();

		if(getIn(node) == null){
			symtable.put(id,getIn(node.getRightExpr()));
			setIn(node,symtable.get(id));
		}	
		else {

			String nameL = getIn(node).getClass().getName();
			String nameR = getIn(node.getRightExpr()).getClass().getName();

			if(nameL != nameR){
				System.out.println("[ " + line + ", " + pos + " ] :Table not defined this way");
				errorCount++;
			}
		}
	}
	//define type of function
	public void outAFuncFunction(AFuncFunction node){
		if(node.getStatement() instanceof AReturnStatement){

			AReturnStatement ret = (AReturnStatement) node.getStatement();
			setIn(node, getIn(ret.getExpression()));
		}

	}
	public void inAIdVArg(AIdVArg node)
	{
		String id = node.getIdentifier().toString();
		symtable.put(id,node.getValue());
		setIn(node,node.getValue());
	}


	//-------------------------------------------------------------------------------------------------------

	// define value of arguments
	public void outAFcFunctionCall(AFcFunctionCall node)
	{

		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		

		if (!symtable.containsKey(id)){
			System.out.println("[ " + line + ", " + pos + " ] : Function " + id +" not defined");
			errorCount++;
		}
		else
		{

		/
			Object temp[] = node.getExpression().toArray();
			int exp = temp.length;
			ArrayList<AFuncFunction> funcs = ((ArrayList<AFuncFunction>) symtable.get(id));
			boolean notThisWay = true;
			for(int i=0; i<funcs.size(); i++)
			{
				AFuncFunction Fnode = funcs.get(i);
				Object args[] =  Fnode.getArg().toArray();
				int nonV = 0 ;
				for(int j = 0; j < args.length; j++ )
				{
					if(args[j] instanceof AIdArg)
					{
						nonV++;
					}
				}
				if((exp>= nonV && exp <= args.length))
				{

					for(int z=0; z<args.length; z++){
						if(node.getExpression().size() <= z){
							break;
						}
						if(args[z] instanceof AIdArg){

							setIn((AIdArg) args[z],getIn((Node) node.getExpression().get(z)));
							symtable.put(((AIdArg) args[z]).getIdentifier().toString(),getIn((AIdArg) args[z]));
						}
						if(args[z] instanceof AIdVArg ){

							String arg = ((AIdVArg) args[z]).getIdentifier().toString();
							symtable.put(arg,((AIdVArg) args[z]).getValue());
							String nameL = symtable.get(arg).getClass().getName();
							String nameR =  node.getExpression().get(z).getClass().getName();

							if(nameL != nameR){
								System.out.println("[ " + line + ", " + pos + " ] : Identifier " + arg +" not defined this way");
								errorCount++;
							}
							
						}

					
					}
					notThisWay = false;
					setIn(node,getIn(Fnode));
					break;
				}
			}

			
			if(notThisWay){
				System.out.println("[ " + line + ", " + pos + " ] : Function " + id +" not defined this way");
				errorCount++;
			}

		}
		
	}

//-----------------------------------------------------------------------------------------------------------
	public void inAValExpression(AValExpression node){
		setIn(node,node.getValue());
	}

	//values for expressions
	public void inAIdExpression(AIdExpression node){
		
		String id = node.getIdentifier().toString();
		setIn(node ,symtable.get(id));

		
	}

	public void inATableExpression(ATableExpression node){
		String id = node.getIdentifier().toString();
		setIn(node ,symtable.get(id));
	}

	public void outAFcExpression(AFcExpression node){
		setIn(node,getIn(node.getFunctionCall()));
		
	}




//------------------------------------------------------------------------------------------------


	// define default(non-initialized) variables
	public void inAForStatement(AForStatement node) 
	{
		String left = node.getLeft().toString();
		String right = node.getRight().toString();
		int Lline = ((TIdentifier) node.getLeft()).getLine();
		int Lpos = ((TIdentifier) node.getLeft()).getPos();
        int Rline = ((TIdentifier) node.getRight()).getLine();
		int Rpos = ((TIdentifier) node.getRight()).getPos(); 
		if (!symtable.containsKey(left)){
			System.out.println("[ " + Lline + ", " + Lpos + " ] : Identifier " + left +" not defined");
			errorCount++;
		}  
		if (!symtable.containsKey(right)){
			System.out.println("[ " + Rline + ", " + Rpos + " ] : Identifier " + right +" not defined");
			errorCount++;
		}

	

	}
	
	// erwthma 1 adhlwth metavlhth se -=
	public void outACalculateMEqStatement(ACalculateMEqStatement node)
	{
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		if (!symtable.containsKey(id)){
			System.out.println("[ " + line + ", " + pos + " ] : Identifier " + id +" not defined");
			errorCount++;
		}
		else
		{
			String nameL = getIn(node).getClass().getName();
			String nameR = getIn(node.getExpression()).getClass().getName();
			if(nameL != nameR){
				System.out.println("[ " + line + ", " + pos + " ] : Id not defined this way");
				errorCount++;
			}
		}
	}
	// erwthma 1 adhlwth metavlhth se /=
	public void outACalculateDEqStatement(ACalculateDEqStatement node)
	{
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();	
		if (!symtable.containsKey(id)){
			System.out.println("[ " + line + ", " + pos + " ] : Identifier " + id +" not defined");
			errorCount++;
		}
		else
		{
			String nameL = getIn(node).getClass().getName();
			String nameR = getIn(node.getExpression()).getClass().getName();
			if(nameL != nameR){
				System.out.println("[ " + line + ", " + pos + " ] : Id not defined this way");
				errorCount++;
			}
		}
	}
	
	




//--------------------------------------------------------------------------------------------------------

	//erwthma 4 string kai integer
	// oxi string se pros8esh
	 public void outAAdditionExpression(AAdditionExpression node)
    {
    	if(!(getIn(node.getL()) instanceof PValue) || !(getIn(node.getR()) instanceof PValue)){
    		return;
    	}
        String nameL = getIn(node.getL()).getClass().getName();
		String nameR = getIn(node.getR()).getClass().getName();
        if(nameL == nameR){
        	setIn(node,getIn(node.getR()));
        }
        else{
        	System.out.println("[ " + valForLine((PValue) getIn(node.getR())) + "] : Cannot add different types");
        	setIn(node,getIn(node.getR())); // gia na mhn petaei null pointer exception
        	errorCount++;
        }
        
    }
    // oxi string se afairesh
    public void outASubtractionExpression(ASubtractionExpression node)
    {
    	if(!(getIn(node.getL()) instanceof PValue) || !(getIn(node.getR()) instanceof PValue)){
    		return;
    	}
        String nameL = getIn(node.getL()).getClass().getName();
		String nameR = getIn(node.getR()).getClass().getName();
        if(nameL == nameR){
        	setIn(node,getIn(node.getR()));
        }
        else{
        	System.out.println("[ " + valForLine((PValue) getIn(node.getR())) + "] : Cannot sub different types");
        	setIn(node,getIn(node.getR())); // gia na mhn petaei null pointer exception
        	errorCount++;
        }
    }
	//oxi string se pollaplasiasmo
	public void outAMultiplicationExpression(AMultiplicationExpression node)
    {
    	if(!(getIn(node.getL()) instanceof PValue) || !(getIn(node.getR()) instanceof PValue)){
    		return;
    	}
        String nameL = getIn(node.getL()).getClass().getName();
		String nameR = getIn(node.getR()).getClass().getName();
        if(nameL == nameR){
        	setIn(node,getIn(node.getR()));
        }
        else{
        	System.out.println("[ " + valForLine((PValue) getIn(node.getR())) + "] : Cannot mult different types");
        	setIn(node,getIn(node.getR())); // gia na mhn petaei null pointer exception
        	errorCount++;
        }
    }
    //oxi string se diairesh
    public void outADivisionExpression(ADivisionExpression node)
    {
    	if(!(getIn(node.getL()) instanceof PValue) || !(getIn(node.getR()) instanceof PValue)){
    		return;
    	}
        String nameL = getIn(node.getL()).getClass().getName();
		String nameR = getIn(node.getR()).getClass().getName();
        if(nameL == nameR){
        	setIn(node,getIn(node.getR()));
        }
        else{
        	System.out.println("[ " + valForLine((PValue) getIn(node.getR())) + "] : Cannot div different types");
        	setIn(node,getIn(node.getR())); // gia na mhn petaei null pointer exception
        	errorCount++;
        }
    }

//---------------------------------------------------------------------------------------------------

    //oxi string se comparison  >
    public void outAGreatcComparison(AGreatcComparison node)
    {
        if(!((getIn(node.getLpar()) instanceof ANumbValue) && (getIn(node.getRpar()) instanceof ANumbValue)) ){
        	
        	System.out.println("[ " + valForLine((PValue) getIn(node.getLpar())) + "] : Cannot compare with string");
        	errorCount++;
        }
      
    }

    //oxi string se comparison  <
    public void outALesscComparison(ALesscComparison node)
    {
       if(!((getIn(node.getLpar()) instanceof ANumbValue) && (getIn(node.getRpar()) instanceof ANumbValue)) ){
        	
        	System.out.println("[ " + valForLine((PValue) getIn(node.getLpar())) + "] : Cannot compare with string");
        	errorCount++;
        }
      
       
    }
    //oxi string se comparison  ==
    public void outAEqcComparison(AEqcComparison node)
    {
       if(!((getIn(node.getLpar()) instanceof ANumbValue) && (getIn(node.getRpar()) instanceof ANumbValue)) ){
        	
        	System.out.println("[ " + valForLine((PValue) getIn(node.getLpar())) + "] : Cannot compare with string");
        	errorCount++;
        }
      
       
    }
    //oxi string se comparison  ==
    public void outANoteqcComparison(ANoteqcComparison node)
    {
        if(!((getIn(node.getLpar()) instanceof ANumbValue) && (getIn(node.getRpar()) instanceof ANumbValue)) ){
        	
        	System.out.println("[ " + valForLine((PValue) getIn(node.getLpar())) + "] : Cannot compare with string");
        	errorCount++;
        }
      
    }

//-----------------------------------------------------------------------------------------------------
    //find Token for line 
    public int valForLine(PValue val)
	{

		if(val instanceof ANumbValue){
			int line = ((ANumbValue) val).getNumber().getLine();
			return line;
		}
		else if(val instanceof AW1Value){

			int line = ((AW1Value) val).getString1().getLine();
			return line;
		}
		else{
			int line = ((AW2Value) val).getString2().getLine();
			return line;
		}

	}
   
//---------------------------------------------------------------------------------------------------------


	public boolean errorFound(){
		if(errorCount == 0){
			return false;
		}
		else{
		System.out.println(" Errors found :" + errorCount + " .");
			return true;
		}
	}


}



