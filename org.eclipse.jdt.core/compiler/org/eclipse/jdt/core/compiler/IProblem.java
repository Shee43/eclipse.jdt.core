package org.eclipse.jdt.core.compiler;
/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
 
import org.eclipse.jdt.internal.compiler.*;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReasons;

public interface IProblem { 
	
	// problem categories
	final int TypeRelated = 0x01000000;
	final int FieldRelated = 0x02000000;
	final int MethodRelated = 0x04000000;
	final int ConstructorRelated = 0x08000000;
	final int ImportRelated = 0x10000000;
	final int Internal = 0x20000000;
	final int IgnoreCategoriesMask = 0xFFFFFF;
	final int UnclassifiedProblem = 0;

	// types
	final int ObjectHasNoSuperclass = TypeRelated + 1;
	final int UndefinedType = TypeRelated + 2;
	final int NotVisibleType = TypeRelated + 3;
	final int AmbiguousType = TypeRelated + 4;
	final int UsingDeprecatedType = TypeRelated + 5;
	final int InternalTypeNameProvided = TypeRelated + 6;

	// type compatibilities
	final int IncompatibleTypesInEqualityOperator = TypeRelated + 15;
	final int IncompatibleTypesInConditionalOperator = TypeRelated + 16;
	final int TypeMismatch = TypeRelated + 17;

	// inner classes
	final int MissingEnclosingInstanceForConstructorCall = TypeRelated + 20;
	final int MissingEnclosingInstance = TypeRelated + 21;
	final int IncorrectEnclosingInstanceReference = TypeRelated + 22;
	final int IllegalEnclosingInstanceSpecification = TypeRelated + 23; 
	final int CannotDefineStaticInitializerInLocalType = Internal + 24;
	final int OuterLocalMustBeFinal = Internal + 25;
	final int CannotDefineInterfaceInLocalType = Internal + 26;
	final int IllegalPrimitiveOrArrayTypeForEnclosingInstance = TypeRelated + 27;
	final int AnonymousClassCannotExtendFinalClass = TypeRelated + 29;

	// variables
	final int UndefinedName = 50;
	final int UninitializedLocalVariable = Internal + 51;
	final int VariableTypeCannotBeVoid = Internal + 52;
	final int VariableTypeCannotBeVoidArray = Internal + 53;
	final int CannotAllocateVoidArray = Internal + 54;
	// local variables
	final int RedefinedLocal = Internal + 55;
	final int RedefinedArgument = Internal + 56;
	final int DuplicateFinalLocalInitialization = Internal + 57;
	// final local variables
	final int FinalOuterLocalAssignment = Internal + 60;
	final int LocalVariableIsNeverUsed = Internal + 61;
	final int ArgumentIsNeverUsed = Internal + 62;
	final int BytecodeExceeds64KLimit = Internal + 63;
	final int BytecodeExceeds64KLimitForClinit = Internal + 64;
	final int TooManyArgumentSlots = Internal + 65;
	final int TooManyLocalVariableSlots = Internal + 66;

	// fields
	final int UndefinedField = FieldRelated + 70;
	final int NotVisibleField = FieldRelated + 71;
	final int AmbiguousField = FieldRelated + 72;
	final int UsingDeprecatedField = FieldRelated + 73;
	final int NonStaticFieldFromStaticInvocation = FieldRelated + 74;
	final int ReferenceToForwardField = FieldRelated + Internal + 75;

	// blank final fields
	final int FinalFieldAssignment = FieldRelated + 80;
	final int UninitializedBlankFinalField = FieldRelated + 81;
	final int DuplicateBlankFinalFieldInitialization = FieldRelated + 82;

	// methods
	final int UndefinedMethod = MethodRelated + 100;
	final int NotVisibleMethod = MethodRelated + 101;
	final int AmbiguousMethod = MethodRelated + 102;
	final int UsingDeprecatedMethod = MethodRelated + 103;
	final int DirectInvocationOfAbstractMethod = MethodRelated + 104;
	final int VoidMethodReturnsValue = MethodRelated + 105;
	final int MethodReturnsVoid = MethodRelated + 106;
	final int MethodRequiresBody = Internal + MethodRelated + 107;
	final int ShouldReturnValue = Internal + MethodRelated + 108;
	final int MethodButWithConstructorName = MethodRelated + 110;
	final int MissingReturnType = TypeRelated + 111;
	final int BodyForNativeMethod = Internal + MethodRelated + 112;
	final int BodyForAbstractMethod = Internal + MethodRelated + 113;
	final int NoMessageSendOnBaseType = MethodRelated + 114;
	final int ParameterMismatch = MethodRelated + 115;
	final int NoMessageSendOnArrayType = MethodRelated + 116;
    
	// constructors
	final int UndefinedConstructor = ConstructorRelated + 130;
	final int NotVisibleConstructor = ConstructorRelated + 131;
	final int AmbiguousConstructor = ConstructorRelated + 132;
	final int UsingDeprecatedConstructor = ConstructorRelated + 133;
	// explicit constructor calls
	final int InstanceFieldDuringConstructorInvocation = ConstructorRelated + 135;
	final int InstanceMethodDuringConstructorInvocation = ConstructorRelated + 136;
	final int RecursiveConstructorInvocation = ConstructorRelated + 137;
	final int ThisSuperDuringConstructorInvocation = ConstructorRelated + 138;

	// expressions
	final int ArrayReferenceRequired = Internal + 150;
	final int NoImplicitStringConversionForCharArrayExpression = Internal + 151;
	// constant expressions
	final int StringConstantIsExceedingUtf8Limit = Internal + 152;
	final int NonConstantExpression = 153;
	final int NumericValueOutOfRange = Internal + 154;
	// cast expressions
	final int IllegalCast = TypeRelated + 156;
	// allocations
	final int InvalidClassInstantiation = TypeRelated + 157;
	final int CannotDefineDimensionExpressionsWithInit = Internal + 158;
	final int MustDefineEitherDimensionExpressionsOrInitializer = Internal + 159;
	// operators
	final int InvalidOperator = Internal + 160;
	// statements
	final int CodeCannotBeReached = Internal + 161;
	final int CannotReturnInInitializer = Internal + 162;
	final int InitializerMustCompleteNormally = Internal + 163;
	
	// assert
	final int InvalidVoidExpression = Internal + 164;
	// try
	final int MaskedCatch = TypeRelated + 165;
	final int DuplicateDefaultCase = 166;
	final int UnreachableCatch = TypeRelated + MethodRelated + 167;
	final int UnhandledException = TypeRelated + 168;
	// switch       
	final int IncorrectSwitchType = TypeRelated + 169;
	final int DuplicateCase = FieldRelated + 170;
	// labelled
	final int DuplicateLabel = Internal + 171;
	final int InvalidBreak = Internal + 172;
	final int InvalidContinue = Internal + 173;
	final int UndefinedLabel = Internal + 174;
	//synchronized
	final int InvalidTypeToSynchronized = Internal + 175;
	final int InvalidNullToSynchronized = Internal + 176;
	// throw
	final int CannotThrowNull = Internal + 177;

	// inner emulation
	final int NeedToEmulateFieldReadAccess = FieldRelated + 190;
	final int NeedToEmulateFieldWriteAccess = FieldRelated + 191;
	final int NeedToEmulateMethodAccess = MethodRelated + 192;
	final int NeedToEmulateConstructorAccess = MethodRelated + 193;

	//inherited name hides enclosing name (sort of ambiguous)
	final int InheritedMethodHidesEnclosingName = MethodRelated + 195;
	final int InheritedFieldHidesEnclosingName = FieldRelated + 196;
	final int InheritedTypeHidesEnclosingName = TypeRelated + 197;

	// miscellaneous
	final int ThisInStaticContext = Internal + 200;
	final int StaticMethodRequested = Internal + MethodRelated + 201;
	final int IllegalDimension = Internal + 202;
	final int InvalidTypeExpression = Internal + 203;
	final int ParsingError = Internal + 204;
	final int ParsingErrorNoSuggestion = Internal + 205;
	final int InvalidUnaryExpression = Internal + 206;

	// syntax errors
	final int InterfaceCannotHaveConstructors = Internal + 207;
	final int ArrayConstantsOnlyInArrayInitializers = Internal + 208;
	final int ParsingErrorOnKeyword = Internal + 209;	
	final int ParsingErrorOnKeywordNoSuggestion = Internal + 210;

	final int UnmatchedBracket = Internal + 220;
	final int NoFieldOnBaseType = FieldRelated + 221;
	final int InvalidExpressionAsStatement = Internal + 222;
    
	// scanner errors
	final int EndOfSource = Internal + 250;
	final int InvalidHexa = Internal + 251;
	final int InvalidOctal = Internal + 252;
	final int InvalidCharacterConstant = Internal + 253;
	final int InvalidEscape = Internal + 254;
	final int InvalidInput = Internal + 255;
	final int InvalidUnicodeEscape = Internal + 256;
	final int InvalidFloat = Internal + 257;
	final int NullSourceString = Internal + 258;
	final int UnterminatedString = Internal + 259;
	final int UnterminatedComment = Internal + 260;

	// type related problems
	final int InterfaceCannotHaveInitializers = TypeRelated + 300;
	final int DuplicateModifierForType = TypeRelated + 301;
	final int IllegalModifierForClass = TypeRelated + 302;
	final int IllegalModifierForInterface = TypeRelated + 303;
	final int IllegalModifierForMemberClass = TypeRelated + 304;
	final int IllegalModifierForMemberInterface = TypeRelated + 305;
	final int IllegalModifierForLocalClass = TypeRelated + 306;

	final int IllegalModifierCombinationFinalAbstractForClass = TypeRelated + 308;
	final int IllegalVisibilityModifierForInterfaceMemberType = TypeRelated + 309;
	final int IllegalVisibilityModifierCombinationForMemberType = TypeRelated + 310;
	final int IllegalStaticModifierForMemberType = TypeRelated + 311;
	final int SuperclassMustBeAClass = TypeRelated + 312;
	final int ClassExtendFinalClass = TypeRelated + 313;
	final int DuplicateSuperInterface = TypeRelated + 314;
	final int SuperInterfaceMustBeAnInterface = TypeRelated + 315;
	final int HierarchyCircularitySelfReference = TypeRelated + 316;
	final int HierarchyCircularity = TypeRelated + 317;
	final int HidingEnclosingType = TypeRelated + 318;
	final int DuplicateNestedType = TypeRelated + 319;
	final int CannotThrowType = TypeRelated + 320;
	final int PackageCollidesWithType = TypeRelated + 321;
	final int TypeCollidesWithPackage = TypeRelated + 322;
	final int DuplicateTypes = TypeRelated + 323;
	final int IsClassPathCorrect = TypeRelated + 324;
	final int PublicClassMustMatchFileName = TypeRelated + 325;
	final int MustSpecifyPackage = 326;
	final int HierarchyHasProblems = TypeRelated + 327;
	final int PackageIsNotExpectedPackage = 328;

	// final int InvalidSuperclassBase = TypeRelated + 329; // reserved to 334 included
	final int SuperclassNotFound =  TypeRelated + 329 + ProblemReasons.NotFound; // TypeRelated + 330
	final int SuperclassNotVisible =  TypeRelated + 329 + ProblemReasons.NotVisible; // TypeRelated + 331
	final int SuperclassAmbiguous =  TypeRelated + 329 + ProblemReasons.Ambiguous; // TypeRelated + 332
	final int SuperclassInternalNameProvided =  TypeRelated + 329 + ProblemReasons.InternalNameProvided; // TypeRelated + 333
	final int SuperclassInheritedNameHidesEnclosingName =  TypeRelated + 329 + ProblemReasons.InheritedNameHidesEnclosingName; // TypeRelated + 334

	// final int InvalidInterfaceBase = TypeRelated + 334; // reserved to 339 included
	final int InterfaceNotFound =  TypeRelated + 334 + ProblemReasons.NotFound; // TypeRelated + 335
	final int InterfaceNotVisible =  TypeRelated + 334 + ProblemReasons.NotVisible; // TypeRelated + 336
	final int InterfaceAmbiguous =  TypeRelated + 334 + ProblemReasons.Ambiguous; // TypeRelated + 337
	final int InterfaceInternalNameProvided =  TypeRelated + 334 + ProblemReasons.InternalNameProvided; // TypeRelated + 338
	final int InterfaceInheritedNameHidesEnclosingName =  TypeRelated + 334 + ProblemReasons.InheritedNameHidesEnclosingName; // TypeRelated + 339

	// field related problems
	final int DuplicateField = FieldRelated + 340;
	final int DuplicateModifierForField = FieldRelated + 341;
	final int IllegalModifierForField = FieldRelated + 342;
	final int IllegalModifierForInterfaceField = FieldRelated + 343;
	final int IllegalVisibilityModifierCombinationForField = FieldRelated + 344;
	final int IllegalModifierCombinationFinalVolatileForField = FieldRelated + 345;
	final int UnexpectedStaticModifierForField = FieldRelated + 346;

	// final int FieldTypeProblemBase = FieldRelated + 349; //reserved to 354
	final int FieldTypeNotFound =  FieldRelated + 349 + ProblemReasons.NotFound; // FieldRelated + 350
	final int FieldTypeNotVisible =  FieldRelated + 349 + ProblemReasons.NotVisible; // FieldRelated + 351
	final int FieldTypeAmbiguous =  FieldRelated + 349 + ProblemReasons.Ambiguous; // FieldRelated + 352
	final int FieldTypeInternalNameProvided =  FieldRelated + 349 + ProblemReasons.InternalNameProvided; // FieldRelated + 353
	final int FieldTypeInheritedNameHidesEnclosingName =  FieldRelated + 349 + ProblemReasons.InheritedNameHidesEnclosingName; // FieldRelated + 354
	
	// method related problems
	final int DuplicateMethod = MethodRelated + 355;
	final int IllegalModifierForArgument = MethodRelated + 356;
	final int DuplicateModifierForMethod = MethodRelated + 357;
	final int IllegalModifierForMethod = MethodRelated + 358;
	final int IllegalModifierForInterfaceMethod = MethodRelated + 359;
	final int IllegalVisibilityModifierCombinationForMethod = MethodRelated + 360;
	final int UnexpectedStaticModifierForMethod = MethodRelated + 361;
	final int IllegalAbstractModifierCombinationForMethod = MethodRelated + 362;
	final int AbstractMethodInAbstractClass = MethodRelated + 363;
	final int ArgumentTypeCannotBeVoid = MethodRelated + 364;
	final int ArgumentTypeCannotBeVoidArray = MethodRelated + 365;
	final int ReturnTypeCannotBeVoidArray = MethodRelated + 366;
	final int NativeMethodsCannotBeStrictfp = MethodRelated + 367;

	//	final int ArgumentProblemBase = MethodRelated + 369; // reserved to 374 included.
	final int ArgumentTypeNotFound =  MethodRelated + 369 + ProblemReasons.NotFound; // MethodRelated + 370
	final int ArgumentTypeNotVisible =  MethodRelated + 369 + ProblemReasons.NotVisible; // MethodRelated + 371
	final int ArgumentTypeAmbiguous =  MethodRelated + 369 + ProblemReasons.Ambiguous; // MethodRelated + 372
	final int ArgumentTypeInternalNameProvided =  MethodRelated + 369 + ProblemReasons.InternalNameProvided; // MethodRelated + 373
	final int ArgumentTypeInheritedNameHidesEnclosingName =  MethodRelated + 369 + ProblemReasons.InheritedNameHidesEnclosingName; // MethodRelated + 374

	//	final int ExceptionTypeProblemBase = MethodRelated + 374; // reserved to 379 included.
	final int ExceptionTypeNotFound =  MethodRelated + 374 + ProblemReasons.NotFound; // MethodRelated + 375
	final int ExceptionTypeNotVisible =  MethodRelated + 374 + ProblemReasons.NotVisible; // MethodRelated + 376
	final int ExceptionTypeAmbiguous =  MethodRelated + 374 + ProblemReasons.Ambiguous; // MethodRelated + 377
	final int ExceptionTypeInternalNameProvided =  MethodRelated + 374 + ProblemReasons.InternalNameProvided; // MethodRelated + 378
	final int ExceptionTypeInheritedNameHidesEnclosingName =  MethodRelated + 374 + ProblemReasons.InheritedNameHidesEnclosingName; // MethodRelated + 379

	//	final int ReturnTypeProblemBase = MethodRelated + 379;
	final int ReturnTypeNotFound =  MethodRelated + 379 + ProblemReasons.NotFound; // MethodRelated + 380
	final int ReturnTypeNotVisible =  MethodRelated + 379 + ProblemReasons.NotVisible; // MethodRelated + 381
	final int ReturnTypeAmbiguous =  MethodRelated + 379 + ProblemReasons.Ambiguous; // MethodRelated + 382
	final int ReturnTypeInternalNameProvided =  MethodRelated + 379 + ProblemReasons.InternalNameProvided; // MethodRelated + 383
	final int ReturnTypeInheritedNameHidesEnclosingName =  MethodRelated + 379 + ProblemReasons.InheritedNameHidesEnclosingName; // MethodRelated + 384

	// import related problems
	final int ConflictingImport = ImportRelated + 385;
	final int DuplicateImport = ImportRelated + 386;
	final int CannotImportPackage = ImportRelated + 387;

	//	final int ImportProblemBase = ImportRelated + 389;
	final int ImportNotFound =  ImportRelated + 389 + ProblemReasons.NotFound; // ImportRelated + 390
	final int ImportNotVisible =  ImportRelated + 389 + ProblemReasons.NotVisible; // ImportRelated + 391
	final int ImportAmbiguous =  ImportRelated + 389 + ProblemReasons.Ambiguous; // ImportRelated + 392
	final int ImportInternalNameProvided =  ImportRelated + 389 + ProblemReasons.InternalNameProvided; // ImportRelated + 393
	final int ImportInheritedNameHidesEnclosingName =  ImportRelated + 389 + ProblemReasons.InheritedNameHidesEnclosingName; // ImportRelated + 394
		
	// local variable related problems
	final int DuplicateModifierForVariable = MethodRelated + 395;
	final int IllegalModifierForVariable = MethodRelated + 396;

	// method verifier problems
	final int AbstractMethodMustBeImplemented = MethodRelated + 400;
	final int FinalMethodCannotBeOverridden = MethodRelated + 401;
	final int IncompatibleExceptionInThrowsClause = MethodRelated + 402;
	final int IncompatibleExceptionInInheritedMethodThrowsClause = MethodRelated + 403;
	final int IncompatibleReturnType = MethodRelated + 404;
	final int InheritedMethodReducesVisibility = MethodRelated + 405;
	final int CannotOverrideAStaticMethodWithAnInstanceMethod = MethodRelated + 406;
	final int CannotHideAnInstanceMethodWithAStaticMethod = MethodRelated + 407;
	final int StaticInheritedMethodConflicts = MethodRelated + 408;
	final int MethodReducesVisibility = MethodRelated + 409;
	final int OverridingNonVisibleMethod = MethodRelated + 410;
	final int AbstractMethodCannotBeOverridden = MethodRelated + 411;
	final int OverridingDeprecatedMethod = MethodRelated + 412;

	// code snippet support
	final int CodeSnippetMissingClass = Internal + 420;
	final int CodeSnippetMissingMethod = Internal + 421;
	final int NonExternalizedStringLiteral = Internal + 261;
	final int CannotUseSuperInCodeSnippet = Internal + 422;
	
	//constant pool
	final int TooManyConstantsInConstantPool = Internal + 430;
	
	// 1.4 features
	// assertion warning
	final int UseAssertAsAnIdentifier = Internal + 440;
	

	final int Error = 1; // when bit is set: problem is error, if not it is a warning

	/**
	 * Answer back the original arguments recorded into the problem.
	 */
	String[] getArguments();

	/**
	 * 
	 * @return int
	 */
	int getID();

	/**
	 * Answer a localized, human-readable message string which describes the problem.
	 */
	String getMessage();
	/**
	 * Answer the file name in which the problem was found.
	 */
	char[] getOriginatingFileName();
	
	/**
	 * Answer the end position of the problem (inclusive), or -1 if unknown.
	 */
	int getSourceEnd();

	/**
	 * Answer the line number in source where the problem begins.
	 */
	int getSourceLineNumber();

	/**
	 * Answer the start position of the problem (inclusive), or -1 if unknown.
	 */
	int getSourceStart();

	/**
	 * Helper method: checks the severity to see if the Error bit is set.
	 */
	boolean isError();

	/**
	 * Helper method: checks the severity to see if the Error bit is not set.
	 */
	boolean isWarning();

	/**
	 * Set the end position of the problem (inclusive), or -1 if unknown.
	 *
	 * Used for shifting problem positions.
	 */
	void setSourceEnd(int sourceEnd);

	/**
	 * Set the line number in source where the problem begins.
	 */
	void setSourceLineNumber(int lineNumber);

	/**
	 * Set the start position of the problem (inclusive), or -1 if unknown.
	 *
	 * Used for shifting problem positions.
	 */
	void setSourceStart(int sourceStart);
}
