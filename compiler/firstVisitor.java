import java.io.*;
import minipython.analysis.*;
import minipython.node.*;
import java.util.*;


public class firstVisitor extends DepthFirstAdapter 
{
	private Hashtable symtable;	
	int errorCount = 0;
	firstVisitor(Hashtable symtable) 
	{
		this.symtable = symtable;
	}

	
	

	//check the number of args and if the function itself has been defined in the program
	public void inAFuncFunction(AFuncFunction node) 
	{

		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		Object temp[] = node.getArg().toArray();

		if (symtable.containsKey(id))
		{
			ArrayList<AFuncFunction> otherFuncs = (ArrayList<AFuncFunction>) symtable.get(id);
			boolean defined = false;
			for(int j=0; j<otherFuncs.size(); j++)
			{
				Object hash_funk[] = otherFuncs.get(j).getArg().toArray();
				int hash_args = 0;
				int args = 0;
				for(int i = 0; i < temp.length; i++ ){
					if(temp[i] instanceof AIdArg){
						args++;
					}
				}
				for(int i = 0; i < hash_funk.length; i++ ){
					if(hash_funk[i] instanceof AIdArg){
						hash_args++;
					}
				}

				if(temp.length == hash_funk.length || args == hash_args){
					System.out.println("[ " + line + ", " + pos + " ] : Function " + id +" is already defined");
					errorCount++;
					defined = true;
				}
			}
			
			if(!defined)
			{
				otherFuncs.add(node);
				symtable.remove(id);
				symtable.put(id, otherFuncs);
				String arg;
				for(int i = 0; i < temp.length; i++ ){
					if(temp[i] instanceof AIdArg){
						 arg = ((AIdArg) temp[i]).getIdentifier().toString();
						 symtable.put(arg,(AIdArg) temp[i]);
					}
					else{
						arg = ((AIdVArg) temp[i]).getIdentifier().toString();
						symtable.put(arg,(AIdVArg) temp[i]);
					}
					
					
				}
			}
			
		}
		else
		{
			ArrayList<AFuncFunction> SameId = new ArrayList<AFuncFunction>();
			SameId.add(node);
			symtable.put(id, SameId);
			String arg;
			for(int i = 0; i < temp.length; i++ )
			{
				if(temp[i] instanceof AIdArg){
					 arg = ((AIdArg) temp[i]).getIdentifier().toString();
				}
				else{
					arg = ((AIdVArg) temp[i]).getIdentifier().toString();
				}
				
				symtable.put(arg, temp[i]);
			}
		}
	}

	//--------------------------------------------------------------------------------------------------
	// define symbols
	// define variables
	public void inACalculateEqStatement(ACalculateEqStatement node)
	{
		String id = node.getIdentifier().toString();
		if (!symtable.containsKey(id)){
			symtable.put(id,node);
		}
	}

	//initialize arrays
	public void inACalculate2Statement(ACalculate2Statement node){
		String id = node.getIdentifier().toString();
		if (!symtable.containsKey(id)){
			symtable.put(id,node);
		}
	}


	//values for expressions
	public void inAIdExpression(AIdExpression node){
		
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		if (!symtable.containsKey(id)){
			System.out.println("[ " + line + ", " + pos + " ] : Identifier " + id +" not defined");
			errorCount++;
		}
		
	}

	public void inATableExpression(ATableExpression node){
		String id = node.getIdentifier().toString();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		int pos = ((TIdentifier) node.getIdentifier()).getPos();
		if (!symtable.containsKey(id)){
			System.out.println("[ " + line + ", " + pos + " ] : Table " + id +" not defined");
			errorCount++;
			
		}
	}
	
	
//--------------------------------------------------------------------------------------------------------
	
	public boolean errorFound()
	{
		if(errorCount == 0){
			return false;
		}
		else{
			System.out.println(" Errors found :" + errorCount + " .");
			return true;
		}
	}


}


