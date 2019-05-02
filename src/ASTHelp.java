import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ASTHelp {
	private CompilationUnit cu;
	
	public ASTHelp (String s)
	{
		cu = parse(s);
	}
	
	public void sendVist(ASTVisitor a)
	{
		this.cu.accept(a);
	}
	
	public static CompilationUnit parse(String s)
	{
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		
		parser.setSource(s.toCharArray());
		
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		
		return (CompilationUnit) parser.createAST(null);
	}
}

//TypeDeclerationVistor is a class pass to the compilation user
//Create A Class Hash which uses ASTvistor to hash each method, type and declerations for a class