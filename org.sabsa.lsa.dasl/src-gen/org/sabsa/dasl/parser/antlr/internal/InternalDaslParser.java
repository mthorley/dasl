package org.sabsa.dasl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.sabsa.dasl.services.DaslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDaslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'import'", "'metadata'", "'zone'", "'{'", "'trustLevel'", "'ingress'", "'egress'", "'nodes'", "'controls'", "'}'", "'node'", "'ref'", "'host'", "'os'", "'type'", "'components'", "'assets'", "'component'", "'stereotype'", "'vendor'", "'desc'", "'version'", "'informationasset'", "'confidentiality'", "'integrity'", "'availability'", "'flow'", "'from'", "'to'", "'actor'", "'roles'", "'control'", "'baseline'", "'description'", "'attestation'", "'baseControl'", "'family'", "'title'", "'PHYSICAL'", "'VIRTUAL'", "'CONTAINER'", "'SHOW_CONTROLS_ON_COMPONENTS'", "'SHOW_CONTROLS_ON_FLOWS'", "'SHOW_ASSETS_ON_FLOWS'", "'SHOW_ASSETS_ON_COMPONENTS'", "'ACCESS_CONTROL'", "'AWARENESS_AND_TRAINING'", "'AUDIT_AND_ACCOUNTABILITY'", "'SECURITY_ASSESSMENT_AND_AUTHORIZATION'", "'CONFIGURATION_MANAGEMENT'", "'CONTINGENCY_PLANNING'", "'IDENTIFICATION_AND_AUTHENTICATION'", "'INCIDENT_RESPONSE'", "'MAINTENANCE'", "'MEDIA_PROTECTION'", "'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION'", "'PLANNING'", "'PROGRAM_MANAGEMENT'", "'PERSONNEL_SECURITY'", "'RISK_ASSESSMENT'", "'SYSTEM_AND_SERVICES_ACQUISITION'", "'SYSTEM_AND_COMMUNICATIONS_PROTECTION'", "'SYSTEM_AND_INFORMATION_INTEGRITY'", "'Public'", "'Internal'", "'Confidential'", "'Restricted'", "'Accurate'", "'HighlyTrusted'", "'Trusted'", "'Uncontrolled'", "'C1'", "'C2'", "'C3'", "'C4'", "'Plastic'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalDaslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDaslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDaslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDasl.g"; }



     	private DaslGrammarAccess grammarAccess;

        public InternalDaslParser(TokenStream input, DaslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SecurityModel";
       	}

       	@Override
       	protected DaslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSecurityModel"
    // InternalDasl.g:65:1: entryRuleSecurityModel returns [EObject current=null] : iv_ruleSecurityModel= ruleSecurityModel EOF ;
    public final EObject entryRuleSecurityModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityModel = null;


        try {
            // InternalDasl.g:65:54: (iv_ruleSecurityModel= ruleSecurityModel EOF )
            // InternalDasl.g:66:2: iv_ruleSecurityModel= ruleSecurityModel EOF
            {
             newCompositeNode(grammarAccess.getSecurityModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSecurityModel=ruleSecurityModel();

            state._fsp--;

             current =iv_ruleSecurityModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecurityModel"


    // $ANTLR start "ruleSecurityModel"
    // InternalDasl.g:72:1: ruleSecurityModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_metadata_1_0= ruleMetadata ) )? ( (lv_elements_2_0= ruleAbstractElement ) )* ) ;
    public final EObject ruleSecurityModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_metadata_1_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_metadata_1_0= ruleMetadata ) )? ( (lv_elements_2_0= ruleAbstractElement ) )* ) )
            // InternalDasl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_metadata_1_0= ruleMetadata ) )? ( (lv_elements_2_0= ruleAbstractElement ) )* )
            {
            // InternalDasl.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_metadata_1_0= ruleMetadata ) )? ( (lv_elements_2_0= ruleAbstractElement ) )* )
            // InternalDasl.g:80:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_metadata_1_0= ruleMetadata ) )? ( (lv_elements_2_0= ruleAbstractElement ) )*
            {
            // InternalDasl.g:80:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDasl.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalDasl.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalDasl.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getSecurityModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecurityModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.sabsa.dasl.Dasl.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDasl.g:99:3: ( (lv_metadata_1_0= ruleMetadata ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDasl.g:100:4: (lv_metadata_1_0= ruleMetadata )
                    {
                    // InternalDasl.g:100:4: (lv_metadata_1_0= ruleMetadata )
                    // InternalDasl.g:101:5: lv_metadata_1_0= ruleMetadata
                    {

                    					newCompositeNode(grammarAccess.getSecurityModelAccess().getMetadataMetadataParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_metadata_1_0=ruleMetadata();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSecurityModelRule());
                    					}
                    					set(
                    						current,
                    						"metadata",
                    						lv_metadata_1_0,
                    						"org.sabsa.dasl.Dasl.Metadata");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDasl.g:118:3: ( (lv_elements_2_0= ruleAbstractElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14||LA3_0==22||LA3_0==29||LA3_0==34||LA3_0==38||LA3_0==41||LA3_0==43||LA3_0==47) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDasl.g:119:4: (lv_elements_2_0= ruleAbstractElement )
            	    {
            	    // InternalDasl.g:119:4: (lv_elements_2_0= ruleAbstractElement )
            	    // InternalDasl.g:120:5: lv_elements_2_0= ruleAbstractElement
            	    {

            	    					newCompositeNode(grammarAccess.getSecurityModelAccess().getElementsAbstractElementParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_elements_2_0=ruleAbstractElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSecurityModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_2_0,
            	    						"org.sabsa.dasl.Dasl.AbstractElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecurityModel"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalDasl.g:141:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDasl.g:141:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDasl.g:142:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalDasl.g:148:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDasl.g:154:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDasl.g:155:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDasl.g:155:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDasl.g:156:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalDasl.g:163:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDasl.g:164:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,11,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_5); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleImport"
    // InternalDasl.g:181:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDasl.g:181:47: (iv_ruleImport= ruleImport EOF )
            // InternalDasl.g:182:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDasl.g:188:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalDasl.g:194:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalDasl.g:195:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalDasl.g:195:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalDasl.g:196:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalDasl.g:200:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalDasl.g:201:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalDasl.g:201:4: (lv_importURI_1_0= RULE_STRING )
            // InternalDasl.g:202:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMetadata"
    // InternalDasl.g:222:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalDasl.g:222:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalDasl.g:223:2: iv_ruleMetadata= ruleMetadata EOF
            {
             newCompositeNode(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadata=ruleMetadata();

            state._fsp--;

             current =iv_ruleMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalDasl.g:229:1: ruleMetadata returns [EObject current=null] : ( () otherlv_1= 'metadata' ( (lv_keys_2_0= ruleMetadataType ) )* ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_keys_2_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:235:2: ( ( () otherlv_1= 'metadata' ( (lv_keys_2_0= ruleMetadataType ) )* ) )
            // InternalDasl.g:236:2: ( () otherlv_1= 'metadata' ( (lv_keys_2_0= ruleMetadataType ) )* )
            {
            // InternalDasl.g:236:2: ( () otherlv_1= 'metadata' ( (lv_keys_2_0= ruleMetadataType ) )* )
            // InternalDasl.g:237:3: () otherlv_1= 'metadata' ( (lv_keys_2_0= ruleMetadataType ) )*
            {
            // InternalDasl.g:237:3: ()
            // InternalDasl.g:238:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMetadataAccess().getMetadataAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getMetadataAccess().getMetadataKeyword_1());
            		
            // InternalDasl.g:248:3: ( (lv_keys_2_0= ruleMetadataType ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=53 && LA5_0<=56)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDasl.g:249:4: (lv_keys_2_0= ruleMetadataType )
            	    {
            	    // InternalDasl.g:249:4: (lv_keys_2_0= ruleMetadataType )
            	    // InternalDasl.g:250:5: lv_keys_2_0= ruleMetadataType
            	    {

            	    					newCompositeNode(grammarAccess.getMetadataAccess().getKeysMetadataTypeEnumRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_keys_2_0=ruleMetadataType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMetadataRule());
            	    					}
            	    					add(
            	    						current,
            	    						"keys",
            	    						lv_keys_2_0,
            	    						"org.sabsa.dasl.Dasl.MetadataType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleZone"
    // InternalDasl.g:271:1: entryRuleZone returns [EObject current=null] : iv_ruleZone= ruleZone EOF ;
    public final EObject entryRuleZone() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleZone = null;


        try {
            // InternalDasl.g:271:45: (iv_ruleZone= ruleZone EOF )
            // InternalDasl.g:272:2: iv_ruleZone= ruleZone EOF
            {
             newCompositeNode(grammarAccess.getZoneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleZone=ruleZone();

            state._fsp--;

             current =iv_ruleZone; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleZone"


    // $ANTLR start "ruleZone"
    // InternalDasl.g:278:1: ruleZone returns [EObject current=null] : (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleZone() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_trust_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalDasl.g:284:2: ( (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) )
            // InternalDasl.g:285:2: (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            {
            // InternalDasl.g:285:2: (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            // InternalDasl.g:286:3: otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getZoneAccess().getZoneKeyword_0());
            		
            // InternalDasl.g:290:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:291:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:291:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:292:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getZoneAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getZoneRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getZoneAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getZoneAccess().getTrustLevelKeyword_3());
            		
            // InternalDasl.g:316:3: ( (lv_trust_4_0= RULE_INT ) )
            // InternalDasl.g:317:4: (lv_trust_4_0= RULE_INT )
            {
            // InternalDasl.g:317:4: (lv_trust_4_0= RULE_INT )
            // InternalDasl.g:318:5: lv_trust_4_0= RULE_INT
            {
            lv_trust_4_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_trust_4_0, grammarAccess.getZoneAccess().getTrustINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getZoneRule());
            					}
            					setWithLastConsumed(
            						current,
            						"trust",
            						lv_trust_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getZoneAccess().getIngressKeyword_5());
            		
            // InternalDasl.g:338:3: ( (otherlv_6= RULE_ID ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDasl.g:339:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalDasl.g:339:4: (otherlv_6= RULE_ID )
            	    // InternalDasl.g:340:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    					newLeafNode(otherlv_6, grammarAccess.getZoneAccess().getIngressZonesZoneCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_7=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getZoneAccess().getEgressKeyword_7());
            		
            // InternalDasl.g:355:3: ( (otherlv_8= RULE_ID ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDasl.g:356:4: (otherlv_8= RULE_ID )
            	    {
            	    // InternalDasl.g:356:4: (otherlv_8= RULE_ID )
            	    // InternalDasl.g:357:5: otherlv_8= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_14); 

            	    					newLeafNode(otherlv_8, grammarAccess.getZoneAccess().getEgressZonesZoneCrossReference_8_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,19,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getZoneAccess().getNodesKeyword_9());
            		
            // InternalDasl.g:372:3: ( (otherlv_10= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDasl.g:373:4: (otherlv_10= RULE_ID )
            	    {
            	    // InternalDasl.g:373:4: (otherlv_10= RULE_ID )
            	    // InternalDasl.g:374:5: otherlv_10= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    					newLeafNode(otherlv_10, grammarAccess.getZoneAccess().getNodesNodeCrossReference_10_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalDasl.g:385:3: (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDasl.g:386:4: otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )*
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_16); 

                    				newLeafNode(otherlv_11, grammarAccess.getZoneAccess().getControlsKeyword_11_0());
                    			
                    // InternalDasl.g:390:4: ( (otherlv_12= RULE_ID ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalDasl.g:391:5: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalDasl.g:391:5: (otherlv_12= RULE_ID )
                    	    // InternalDasl.g:392:6: otherlv_12= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getZoneRule());
                    	    						}
                    	    					
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getZoneAccess().getControlsControlCrossReference_11_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getZoneAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleZone"


    // $ANTLR start "entryRuleNode"
    // InternalDasl.g:412:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalDasl.g:412:45: (iv_ruleNode= ruleNode EOF )
            // InternalDasl.g:413:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalDasl.g:419:1: ruleNode returns [EObject current=null] : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )? (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )? otherlv_17= '}' ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_ref_4_0=null;
        Token otherlv_5=null;
        Token lv_host_6_0=null;
        Token otherlv_7=null;
        Token lv_os_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Enumerator lv_value_10_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:425:2: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )? (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )? otherlv_17= '}' ) )
            // InternalDasl.g:426:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )? (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )? otherlv_17= '}' )
            {
            // InternalDasl.g:426:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )? (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )? otherlv_17= '}' )
            // InternalDasl.g:427:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )? (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalDasl.g:431:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:432:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:432:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:433:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getNodeAccess().getRefKeyword_3());
            		
            // InternalDasl.g:457:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:458:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:458:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:459:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getNodeAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getNodeAccess().getHostKeyword_5());
            		
            // InternalDasl.g:479:3: ( (lv_host_6_0= RULE_STRING ) )
            // InternalDasl.g:480:4: (lv_host_6_0= RULE_STRING )
            {
            // InternalDasl.g:480:4: (lv_host_6_0= RULE_STRING )
            // InternalDasl.g:481:5: lv_host_6_0= RULE_STRING
            {
            lv_host_6_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_host_6_0, grammarAccess.getNodeAccess().getHostSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"host",
            						lv_host_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getOsKeyword_7());
            		
            // InternalDasl.g:501:3: ( (lv_os_8_0= RULE_STRING ) )
            // InternalDasl.g:502:4: (lv_os_8_0= RULE_STRING )
            {
            // InternalDasl.g:502:4: (lv_os_8_0= RULE_STRING )
            // InternalDasl.g:503:5: lv_os_8_0= RULE_STRING
            {
            lv_os_8_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_os_8_0, grammarAccess.getNodeAccess().getOsSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"os",
            						lv_os_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getTypeKeyword_9());
            		
            // InternalDasl.g:523:3: ( (lv_value_10_0= ruleNodeType ) )
            // InternalDasl.g:524:4: (lv_value_10_0= ruleNodeType )
            {
            // InternalDasl.g:524:4: (lv_value_10_0= ruleNodeType )
            // InternalDasl.g:525:5: lv_value_10_0= ruleNodeType
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getValueNodeTypeEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_22);
            lv_value_10_0=ruleNodeType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_10_0,
            						"org.sabsa.dasl.Dasl.NodeType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDasl.g:542:3: (otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDasl.g:543:4: otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )*
                    {
                    otherlv_11=(Token)match(input,27,FOLLOW_23); 

                    				newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getComponentsKeyword_11_0());
                    			
                    // InternalDasl.g:547:4: ( (otherlv_12= RULE_ID ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalDasl.g:548:5: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalDasl.g:548:5: (otherlv_12= RULE_ID )
                    	    // InternalDasl.g:549:6: otherlv_12= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_23); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getNodeAccess().getComponentsComponentCrossReference_11_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:561:3: (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDasl.g:562:4: otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )*
                    {
                    otherlv_13=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getControlsKeyword_12_0());
                    			
                    // InternalDasl.g:566:4: ( (otherlv_14= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalDasl.g:567:5: (otherlv_14= RULE_ID )
                    	    {
                    	    // InternalDasl.g:567:5: (otherlv_14= RULE_ID )
                    	    // InternalDasl.g:568:6: otherlv_14= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_24); 

                    	    						newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getControlsControlCrossReference_12_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:580:3: (otherlv_15= 'assets' ( ( ruleQualifiedName ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDasl.g:581:4: otherlv_15= 'assets' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_15=(Token)match(input,28,FOLLOW_16); 

                    				newLeafNode(otherlv_15, grammarAccess.getNodeAccess().getAssetsKeyword_13_0());
                    			
                    // InternalDasl.g:585:4: ( ( ruleQualifiedName ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalDasl.g:586:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalDasl.g:586:5: ( ruleQualifiedName )
                    	    // InternalDasl.g:587:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getNodeAccess().getAssetsInformationAssetCrossReference_13_1_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleComponent"
    // InternalDasl.g:610:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalDasl.g:610:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalDasl.g:611:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalDasl.g:617:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_ref_4_0=null;
        Token otherlv_5=null;
        Token lv_stereotype_6_0=null;
        Token otherlv_7=null;
        Token lv_vendor_8_0=null;
        Token otherlv_9=null;
        Token lv_desc_10_0=null;
        Token otherlv_11=null;
        Token lv_version_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_components_17_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:623:2: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' ) )
            // InternalDasl.g:624:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' )
            {
            // InternalDasl.g:624:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' )
            // InternalDasl.g:625:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
            		
            // InternalDasl.g:629:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:630:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:630:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:631:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getComponentAccess().getRefKeyword_3());
            		
            // InternalDasl.g:655:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:656:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:656:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:657:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getComponentAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getComponentAccess().getStereotypeKeyword_5());
            		
            // InternalDasl.g:677:3: ( (lv_stereotype_6_0= RULE_STRING ) )
            // InternalDasl.g:678:4: (lv_stereotype_6_0= RULE_STRING )
            {
            // InternalDasl.g:678:4: (lv_stereotype_6_0= RULE_STRING )
            // InternalDasl.g:679:5: lv_stereotype_6_0= RULE_STRING
            {
            lv_stereotype_6_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_stereotype_6_0, grammarAccess.getComponentAccess().getStereotypeSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"stereotype",
            						lv_stereotype_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalDasl.g:695:3: (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDasl.g:696:4: otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getComponentAccess().getVendorKeyword_7_0());
                    			
                    // InternalDasl.g:700:4: ( (lv_vendor_8_0= RULE_STRING ) )
                    // InternalDasl.g:701:5: (lv_vendor_8_0= RULE_STRING )
                    {
                    // InternalDasl.g:701:5: (lv_vendor_8_0= RULE_STRING )
                    // InternalDasl.g:702:6: lv_vendor_8_0= RULE_STRING
                    {
                    lv_vendor_8_0=(Token)match(input,RULE_STRING,FOLLOW_27); 

                    						newLeafNode(lv_vendor_8_0, grammarAccess.getComponentAccess().getVendorSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComponentRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"vendor",
                    							lv_vendor_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getComponentAccess().getDescKeyword_8());
            		
            // InternalDasl.g:723:3: ( (lv_desc_10_0= RULE_STRING ) )
            // InternalDasl.g:724:4: (lv_desc_10_0= RULE_STRING )
            {
            // InternalDasl.g:724:4: (lv_desc_10_0= RULE_STRING )
            // InternalDasl.g:725:5: lv_desc_10_0= RULE_STRING
            {
            lv_desc_10_0=(Token)match(input,RULE_STRING,FOLLOW_28); 

            					newLeafNode(lv_desc_10_0, grammarAccess.getComponentAccess().getDescSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"desc",
            						lv_desc_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_11, grammarAccess.getComponentAccess().getVersionKeyword_10());
            		
            // InternalDasl.g:745:3: ( (lv_version_12_0= RULE_STRING ) )
            // InternalDasl.g:746:4: (lv_version_12_0= RULE_STRING )
            {
            // InternalDasl.g:746:4: (lv_version_12_0= RULE_STRING )
            // InternalDasl.g:747:5: lv_version_12_0= RULE_STRING
            {
            lv_version_12_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

            					newLeafNode(lv_version_12_0, grammarAccess.getComponentAccess().getVersionSTRINGTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"version",
            						lv_version_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalDasl.g:763:3: (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDasl.g:764:4: otherlv_13= 'assets' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_30); 

                    				newLeafNode(otherlv_13, grammarAccess.getComponentAccess().getAssetsKeyword_12_0());
                    			
                    // InternalDasl.g:768:4: ( ( ruleQualifiedName ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalDasl.g:769:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalDasl.g:769:5: ( ruleQualifiedName )
                    	    // InternalDasl.g:770:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getComponentRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getComponentAccess().getAssetsInformationAssetCrossReference_12_1_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:785:3: (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDasl.g:786:4: otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )*
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_31); 

                    				newLeafNode(otherlv_15, grammarAccess.getComponentAccess().getControlsKeyword_13_0());
                    			
                    // InternalDasl.g:790:4: ( (otherlv_16= RULE_ID ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalDasl.g:791:5: (otherlv_16= RULE_ID )
                    	    {
                    	    // InternalDasl.g:791:5: (otherlv_16= RULE_ID )
                    	    // InternalDasl.g:792:6: otherlv_16= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getComponentRule());
                    	    						}
                    	    					
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_31); 

                    	    						newLeafNode(otherlv_16, grammarAccess.getComponentAccess().getControlsControlCrossReference_13_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:804:3: ( (lv_components_17_0= ruleComponent ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDasl.g:805:4: (lv_components_17_0= ruleComponent )
            	    {
            	    // InternalDasl.g:805:4: (lv_components_17_0= ruleComponent )
            	    // InternalDasl.g:806:5: lv_components_17_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getComponentAccess().getComponentsComponentParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_components_17_0=ruleComponent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComponentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_17_0,
            	    						"org.sabsa.dasl.Dasl.Component");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_18=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleInformationAsset"
    // InternalDasl.g:831:1: entryRuleInformationAsset returns [EObject current=null] : iv_ruleInformationAsset= ruleInformationAsset EOF ;
    public final EObject entryRuleInformationAsset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformationAsset = null;


        try {
            // InternalDasl.g:831:57: (iv_ruleInformationAsset= ruleInformationAsset EOF )
            // InternalDasl.g:832:2: iv_ruleInformationAsset= ruleInformationAsset EOF
            {
             newCompositeNode(grammarAccess.getInformationAssetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInformationAsset=ruleInformationAsset();

            state._fsp--;

             current =iv_ruleInformationAsset; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInformationAsset"


    // $ANTLR start "ruleInformationAsset"
    // InternalDasl.g:838:1: ruleInformationAsset returns [EObject current=null] : (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' ) ;
    public final EObject ruleInformationAsset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_ref_4_0=null;
        Token otherlv_5=null;
        Token lv_desc_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Enumerator lv_confidentiality_8_0 = null;

        Enumerator lv_integrity_10_0 = null;

        Enumerator lv_availability_12_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:844:2: ( (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' ) )
            // InternalDasl.g:845:2: (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' )
            {
            // InternalDasl.g:845:2: (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' )
            // InternalDasl.g:846:3: otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getInformationAssetAccess().getInformationassetKeyword_0());
            		
            // InternalDasl.g:850:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:851:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:851:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:852:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInformationAssetAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationAssetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getInformationAssetAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getInformationAssetAccess().getRefKeyword_3());
            		
            // InternalDasl.g:876:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:877:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:877:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:878:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getInformationAssetAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationAssetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getInformationAssetAccess().getDescKeyword_5());
            		
            // InternalDasl.g:898:3: ( (lv_desc_6_0= RULE_STRING ) )
            // InternalDasl.g:899:4: (lv_desc_6_0= RULE_STRING )
            {
            // InternalDasl.g:899:4: (lv_desc_6_0= RULE_STRING )
            // InternalDasl.g:900:5: lv_desc_6_0= RULE_STRING
            {
            lv_desc_6_0=(Token)match(input,RULE_STRING,FOLLOW_33); 

            					newLeafNode(lv_desc_6_0, grammarAccess.getInformationAssetAccess().getDescSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationAssetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"desc",
            						lv_desc_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,35,FOLLOW_34); 

            			newLeafNode(otherlv_7, grammarAccess.getInformationAssetAccess().getConfidentialityKeyword_7());
            		
            // InternalDasl.g:920:3: ( (lv_confidentiality_8_0= ruleConfidentialityType ) )
            // InternalDasl.g:921:4: (lv_confidentiality_8_0= ruleConfidentialityType )
            {
            // InternalDasl.g:921:4: (lv_confidentiality_8_0= ruleConfidentialityType )
            // InternalDasl.g:922:5: lv_confidentiality_8_0= ruleConfidentialityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getConfidentialityConfidentialityTypeEnumRuleCall_8_0());
            				
            pushFollow(FOLLOW_35);
            lv_confidentiality_8_0=ruleConfidentialityType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInformationAssetRule());
            					}
            					set(
            						current,
            						"confidentiality",
            						lv_confidentiality_8_0,
            						"org.sabsa.dasl.Dasl.ConfidentialityType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,36,FOLLOW_36); 

            			newLeafNode(otherlv_9, grammarAccess.getInformationAssetAccess().getIntegrityKeyword_9());
            		
            // InternalDasl.g:943:3: ( (lv_integrity_10_0= ruleIntegrityType ) )
            // InternalDasl.g:944:4: (lv_integrity_10_0= ruleIntegrityType )
            {
            // InternalDasl.g:944:4: (lv_integrity_10_0= ruleIntegrityType )
            // InternalDasl.g:945:5: lv_integrity_10_0= ruleIntegrityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getIntegrityIntegrityTypeEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_37);
            lv_integrity_10_0=ruleIntegrityType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInformationAssetRule());
            					}
            					set(
            						current,
            						"integrity",
            						lv_integrity_10_0,
            						"org.sabsa.dasl.Dasl.IntegrityType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,37,FOLLOW_38); 

            			newLeafNode(otherlv_11, grammarAccess.getInformationAssetAccess().getAvailabilityKeyword_11());
            		
            // InternalDasl.g:966:3: ( (lv_availability_12_0= ruleAvailabilityType ) )
            // InternalDasl.g:967:4: (lv_availability_12_0= ruleAvailabilityType )
            {
            // InternalDasl.g:967:4: (lv_availability_12_0= ruleAvailabilityType )
            // InternalDasl.g:968:5: lv_availability_12_0= ruleAvailabilityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getAvailabilityAvailabilityTypeEnumRuleCall_12_0());
            				
            pushFollow(FOLLOW_39);
            lv_availability_12_0=ruleAvailabilityType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInformationAssetRule());
            					}
            					set(
            						current,
            						"availability",
            						lv_availability_12_0,
            						"org.sabsa.dasl.Dasl.AvailabilityType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getInformationAssetAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInformationAsset"


    // $ANTLR start "entryRuleFlow"
    // InternalDasl.g:993:1: entryRuleFlow returns [EObject current=null] : iv_ruleFlow= ruleFlow EOF ;
    public final EObject entryRuleFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlow = null;


        try {
            // InternalDasl.g:993:45: (iv_ruleFlow= ruleFlow EOF )
            // InternalDasl.g:994:2: iv_ruleFlow= ruleFlow EOF
            {
             newCompositeNode(grammarAccess.getFlowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlow=ruleFlow();

            state._fsp--;

             current =iv_ruleFlow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlow"


    // $ANTLR start "ruleFlow"
    // InternalDasl.g:1000:1: ruleFlow returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )? otherlv_5= 'from' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'to' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleFlow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_desc_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalDasl.g:1006:2: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )? otherlv_5= 'from' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'to' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) )
            // InternalDasl.g:1007:2: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )? otherlv_5= 'from' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'to' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            {
            // InternalDasl.g:1007:2: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )? otherlv_5= 'from' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'to' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            // InternalDasl.g:1008:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )? otherlv_5= 'from' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'to' ( (otherlv_8= RULE_ID ) ) (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFlowAccess().getFlowKeyword_0());
            		
            // InternalDasl.g:1012:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:1013:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:1013:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:1014:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFlowAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getFlowAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDasl.g:1034:3: (otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDasl.g:1035:4: otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getFlowAccess().getDescKeyword_3_0());
                    			
                    // InternalDasl.g:1039:4: ( (lv_desc_4_0= RULE_STRING ) )
                    // InternalDasl.g:1040:5: (lv_desc_4_0= RULE_STRING )
                    {
                    // InternalDasl.g:1040:5: (lv_desc_4_0= RULE_STRING )
                    // InternalDasl.g:1041:6: lv_desc_4_0= RULE_STRING
                    {
                    lv_desc_4_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

                    						newLeafNode(lv_desc_4_0, grammarAccess.getFlowAccess().getDescSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFlowRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"desc",
                    							lv_desc_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getFlowAccess().getFromKeyword_4());
            		
            // InternalDasl.g:1062:3: ( (otherlv_6= RULE_ID ) )
            // InternalDasl.g:1063:4: (otherlv_6= RULE_ID )
            {
            // InternalDasl.g:1063:4: (otherlv_6= RULE_ID )
            // InternalDasl.g:1064:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_6, grammarAccess.getFlowAccess().getFromFlowEndpointCrossReference_5_0());
            				

            }


            }

            otherlv_7=(Token)match(input,40,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getFlowAccess().getToKeyword_6());
            		
            // InternalDasl.g:1079:3: ( (otherlv_8= RULE_ID ) )
            // InternalDasl.g:1080:4: (otherlv_8= RULE_ID )
            {
            // InternalDasl.g:1080:4: (otherlv_8= RULE_ID )
            // InternalDasl.g:1081:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(otherlv_8, grammarAccess.getFlowAccess().getToFlowEndpointCrossReference_7_0());
            				

            }


            }

            // InternalDasl.g:1092:3: (otherlv_9= 'assets' ( ( ruleQualifiedName ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalDasl.g:1093:4: otherlv_9= 'assets' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_9=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_9, grammarAccess.getFlowAccess().getAssetsKeyword_8_0());
                    			
                    // InternalDasl.g:1097:4: ( ( ruleQualifiedName ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalDasl.g:1098:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalDasl.g:1098:5: ( ruleQualifiedName )
                    	    // InternalDasl.g:1099:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getFlowRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getFlowAccess().getAssetsInformationAssetCrossReference_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_15);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:1114:3: (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDasl.g:1115:4: otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )*
                    {
                    otherlv_11=(Token)match(input,20,FOLLOW_16); 

                    				newLeafNode(otherlv_11, grammarAccess.getFlowAccess().getControlsKeyword_9_0());
                    			
                    // InternalDasl.g:1119:4: ( (otherlv_12= RULE_ID ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalDasl.g:1120:5: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalDasl.g:1120:5: (otherlv_12= RULE_ID )
                    	    // InternalDasl.g:1121:6: otherlv_12= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getFlowRule());
                    	    						}
                    	    					
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_16); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getFlowAccess().getControlsControlCrossReference_9_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getFlowAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlow"


    // $ANTLR start "entryRuleActor"
    // InternalDasl.g:1141:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalDasl.g:1141:46: (iv_ruleActor= ruleActor EOF )
            // InternalDasl.g:1142:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalDasl.g:1148:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) otherlv_5= 'roles' ( (lv_roles_6_0= RULE_STRING ) ) otherlv_7= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_desc_4_0=null;
        Token otherlv_5=null;
        Token lv_roles_6_0=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalDasl.g:1154:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) otherlv_5= 'roles' ( (lv_roles_6_0= RULE_STRING ) ) otherlv_7= '}' ) )
            // InternalDasl.g:1155:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) otherlv_5= 'roles' ( (lv_roles_6_0= RULE_STRING ) ) otherlv_7= '}' )
            {
            // InternalDasl.g:1155:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) otherlv_5= 'roles' ( (lv_roles_6_0= RULE_STRING ) ) otherlv_7= '}' )
            // InternalDasl.g:1156:3: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'desc' ( (lv_desc_4_0= RULE_STRING ) ) otherlv_5= 'roles' ( (lv_roles_6_0= RULE_STRING ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalDasl.g:1160:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:1161:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:1161:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:1162:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getActorAccess().getDescKeyword_3());
            		
            // InternalDasl.g:1186:3: ( (lv_desc_4_0= RULE_STRING ) )
            // InternalDasl.g:1187:4: (lv_desc_4_0= RULE_STRING )
            {
            // InternalDasl.g:1187:4: (lv_desc_4_0= RULE_STRING )
            // InternalDasl.g:1188:5: lv_desc_4_0= RULE_STRING
            {
            lv_desc_4_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            					newLeafNode(lv_desc_4_0, grammarAccess.getActorAccess().getDescSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"desc",
            						lv_desc_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getActorAccess().getRolesKeyword_5());
            		
            // InternalDasl.g:1208:3: ( (lv_roles_6_0= RULE_STRING ) )
            // InternalDasl.g:1209:4: (lv_roles_6_0= RULE_STRING )
            {
            // InternalDasl.g:1209:4: (lv_roles_6_0= RULE_STRING )
            // InternalDasl.g:1210:5: lv_roles_6_0= RULE_STRING
            {
            lv_roles_6_0=(Token)match(input,RULE_STRING,FOLLOW_39); 

            					newLeafNode(lv_roles_6_0, grammarAccess.getActorAccess().getRolesSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"roles",
            						lv_roles_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleControl"
    // InternalDasl.g:1234:1: entryRuleControl returns [EObject current=null] : iv_ruleControl= ruleControl EOF ;
    public final EObject entryRuleControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControl = null;


        try {
            // InternalDasl.g:1234:48: (iv_ruleControl= ruleControl EOF )
            // InternalDasl.g:1235:2: iv_ruleControl= ruleControl EOF
            {
             newCompositeNode(grammarAccess.getControlRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleControl=ruleControl();

            state._fsp--;

             current =iv_ruleControl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleControl"


    // $ANTLR start "ruleControl"
    // InternalDasl.g:1241:1: ruleControl returns [EObject current=null] : (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'baseline' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= 'attestation' ( (lv_att_10_0= RULE_STRING ) ) otherlv_11= '}' ) ;
    public final EObject ruleControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_ref_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_desc_8_0=null;
        Token otherlv_9=null;
        Token lv_att_10_0=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalDasl.g:1247:2: ( (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'baseline' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= 'attestation' ( (lv_att_10_0= RULE_STRING ) ) otherlv_11= '}' ) )
            // InternalDasl.g:1248:2: (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'baseline' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= 'attestation' ( (lv_att_10_0= RULE_STRING ) ) otherlv_11= '}' )
            {
            // InternalDasl.g:1248:2: (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'baseline' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= 'attestation' ( (lv_att_10_0= RULE_STRING ) ) otherlv_11= '}' )
            // InternalDasl.g:1249:3: otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'baseline' ( (otherlv_6= RULE_ID ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= 'attestation' ( (lv_att_10_0= RULE_STRING ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getControlAccess().getControlKeyword_0());
            		
            // InternalDasl.g:1253:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:1254:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:1254:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:1255:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getControlAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getControlAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getControlAccess().getRefKeyword_3());
            		
            // InternalDasl.g:1279:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:1280:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:1280:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:1281:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getControlAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,44,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getControlAccess().getBaselineKeyword_5());
            		
            // InternalDasl.g:1301:3: ( (otherlv_6= RULE_ID ) )
            // InternalDasl.g:1302:4: (otherlv_6= RULE_ID )
            {
            // InternalDasl.g:1302:4: (otherlv_6= RULE_ID )
            // InternalDasl.g:1303:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_46); 

            					newLeafNode(otherlv_6, grammarAccess.getControlAccess().getBaseBaseControlCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getControlAccess().getDescriptionKeyword_7());
            		
            // InternalDasl.g:1318:3: ( (lv_desc_8_0= RULE_STRING ) )
            // InternalDasl.g:1319:4: (lv_desc_8_0= RULE_STRING )
            {
            // InternalDasl.g:1319:4: (lv_desc_8_0= RULE_STRING )
            // InternalDasl.g:1320:5: lv_desc_8_0= RULE_STRING
            {
            lv_desc_8_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

            					newLeafNode(lv_desc_8_0, grammarAccess.getControlAccess().getDescSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"desc",
            						lv_desc_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,46,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getControlAccess().getAttestationKeyword_9());
            		
            // InternalDasl.g:1340:3: ( (lv_att_10_0= RULE_STRING ) )
            // InternalDasl.g:1341:4: (lv_att_10_0= RULE_STRING )
            {
            // InternalDasl.g:1341:4: (lv_att_10_0= RULE_STRING )
            // InternalDasl.g:1342:5: lv_att_10_0= RULE_STRING
            {
            lv_att_10_0=(Token)match(input,RULE_STRING,FOLLOW_39); 

            					newLeafNode(lv_att_10_0, grammarAccess.getControlAccess().getAttSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"att",
            						lv_att_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getControlAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleControl"


    // $ANTLR start "entryRuleBaseControl"
    // InternalDasl.g:1366:1: entryRuleBaseControl returns [EObject current=null] : iv_ruleBaseControl= ruleBaseControl EOF ;
    public final EObject entryRuleBaseControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseControl = null;


        try {
            // InternalDasl.g:1366:52: (iv_ruleBaseControl= ruleBaseControl EOF )
            // InternalDasl.g:1367:2: iv_ruleBaseControl= ruleBaseControl EOF
            {
             newCompositeNode(grammarAccess.getBaseControlRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBaseControl=ruleBaseControl();

            state._fsp--;

             current =iv_ruleBaseControl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseControl"


    // $ANTLR start "ruleBaseControl"
    // InternalDasl.g:1373:1: ruleBaseControl returns [EObject current=null] : (otherlv_0= 'baseControl' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'family' ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) ) otherlv_5= 'title' ( (lv_title_6_0= RULE_STRING ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleBaseControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_title_6_0=null;
        Token otherlv_7=null;
        Token lv_desc_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_family_4_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:1379:2: ( (otherlv_0= 'baseControl' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'family' ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) ) otherlv_5= 'title' ( (lv_title_6_0= RULE_STRING ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // InternalDasl.g:1380:2: (otherlv_0= 'baseControl' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'family' ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) ) otherlv_5= 'title' ( (lv_title_6_0= RULE_STRING ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // InternalDasl.g:1380:2: (otherlv_0= 'baseControl' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'family' ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) ) otherlv_5= 'title' ( (lv_title_6_0= RULE_STRING ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // InternalDasl.g:1381:3: otherlv_0= 'baseControl' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'family' ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) ) otherlv_5= 'title' ( (lv_title_6_0= RULE_STRING ) ) otherlv_7= 'description' ( (lv_desc_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getBaseControlAccess().getBaseControlKeyword_0());
            		
            // InternalDasl.g:1385:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:1386:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:1386:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:1387:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBaseControlAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBaseControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.sabsa.dasl.Dasl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getBaseControlAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,48,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getBaseControlAccess().getFamilyKeyword_3());
            		
            // InternalDasl.g:1411:3: ( (lv_family_4_0= ruleNIST80053ARev4_FamilyType ) )
            // InternalDasl.g:1412:4: (lv_family_4_0= ruleNIST80053ARev4_FamilyType )
            {
            // InternalDasl.g:1412:4: (lv_family_4_0= ruleNIST80053ARev4_FamilyType )
            // InternalDasl.g:1413:5: lv_family_4_0= ruleNIST80053ARev4_FamilyType
            {

            					newCompositeNode(grammarAccess.getBaseControlAccess().getFamilyNIST80053ARev4_FamilyTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_50);
            lv_family_4_0=ruleNIST80053ARev4_FamilyType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBaseControlRule());
            					}
            					set(
            						current,
            						"family",
            						lv_family_4_0,
            						"org.sabsa.dasl.Dasl.NIST80053ARev4_FamilyType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,49,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getBaseControlAccess().getTitleKeyword_5());
            		
            // InternalDasl.g:1434:3: ( (lv_title_6_0= RULE_STRING ) )
            // InternalDasl.g:1435:4: (lv_title_6_0= RULE_STRING )
            {
            // InternalDasl.g:1435:4: (lv_title_6_0= RULE_STRING )
            // InternalDasl.g:1436:5: lv_title_6_0= RULE_STRING
            {
            lv_title_6_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

            					newLeafNode(lv_title_6_0, grammarAccess.getBaseControlAccess().getTitleSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBaseControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"title",
            						lv_title_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getBaseControlAccess().getDescriptionKeyword_7());
            		
            // InternalDasl.g:1456:3: ( (lv_desc_8_0= RULE_STRING ) )
            // InternalDasl.g:1457:4: (lv_desc_8_0= RULE_STRING )
            {
            // InternalDasl.g:1457:4: (lv_desc_8_0= RULE_STRING )
            // InternalDasl.g:1458:5: lv_desc_8_0= RULE_STRING
            {
            lv_desc_8_0=(Token)match(input,RULE_STRING,FOLLOW_39); 

            					newLeafNode(lv_desc_8_0, grammarAccess.getBaseControlAccess().getDescSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBaseControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"desc",
            						lv_desc_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBaseControlAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseControl"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalDasl.g:1482:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalDasl.g:1482:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalDasl.g:1483:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalDasl.g:1489:1: ruleAbstractElement returns [EObject current=null] : (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Actor_4= ruleActor | this_Control_5= ruleControl | this_Flow_6= ruleFlow | this_BaseControl_7= ruleBaseControl ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_InformationAsset_0 = null;

        EObject this_Component_1 = null;

        EObject this_Zone_2 = null;

        EObject this_Node_3 = null;

        EObject this_Actor_4 = null;

        EObject this_Control_5 = null;

        EObject this_Flow_6 = null;

        EObject this_BaseControl_7 = null;



        	enterRule();

        try {
            // InternalDasl.g:1495:2: ( (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Actor_4= ruleActor | this_Control_5= ruleControl | this_Flow_6= ruleFlow | this_BaseControl_7= ruleBaseControl ) )
            // InternalDasl.g:1496:2: (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Actor_4= ruleActor | this_Control_5= ruleControl | this_Flow_6= ruleFlow | this_BaseControl_7= ruleBaseControl )
            {
            // InternalDasl.g:1496:2: (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Actor_4= ruleActor | this_Control_5= ruleControl | this_Flow_6= ruleFlow | this_BaseControl_7= ruleBaseControl )
            int alt28=8;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt28=1;
                }
                break;
            case 29:
                {
                alt28=2;
                }
                break;
            case 14:
                {
                alt28=3;
                }
                break;
            case 22:
                {
                alt28=4;
                }
                break;
            case 41:
                {
                alt28=5;
                }
                break;
            case 43:
                {
                alt28=6;
                }
                break;
            case 38:
                {
                alt28=7;
                }
                break;
            case 47:
                {
                alt28=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalDasl.g:1497:3: this_InformationAsset_0= ruleInformationAsset
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getInformationAssetParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InformationAsset_0=ruleInformationAsset();

                    state._fsp--;


                    			current = this_InformationAsset_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDasl.g:1506:3: this_Component_1= ruleComponent
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getComponentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Component_1=ruleComponent();

                    state._fsp--;


                    			current = this_Component_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDasl.g:1515:3: this_Zone_2= ruleZone
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getZoneParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Zone_2=ruleZone();

                    state._fsp--;


                    			current = this_Zone_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDasl.g:1524:3: this_Node_3= ruleNode
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getNodeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Node_3=ruleNode();

                    state._fsp--;


                    			current = this_Node_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDasl.g:1533:3: this_Actor_4= ruleActor
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getActorParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Actor_4=ruleActor();

                    state._fsp--;


                    			current = this_Actor_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDasl.g:1542:3: this_Control_5= ruleControl
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getControlParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Control_5=ruleControl();

                    state._fsp--;


                    			current = this_Control_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalDasl.g:1551:3: this_Flow_6= ruleFlow
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getFlowParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Flow_6=ruleFlow();

                    state._fsp--;


                    			current = this_Flow_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalDasl.g:1560:3: this_BaseControl_7= ruleBaseControl
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getBaseControlParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_BaseControl_7=ruleBaseControl();

                    state._fsp--;


                    			current = this_BaseControl_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "ruleNodeType"
    // InternalDasl.g:1572:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDasl.g:1578:2: ( ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) ) )
            // InternalDasl.g:1579:2: ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) )
            {
            // InternalDasl.g:1579:2: ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt29=1;
                }
                break;
            case 51:
                {
                alt29=2;
                }
                break;
            case 52:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalDasl.g:1580:3: (enumLiteral_0= 'PHYSICAL' )
                    {
                    // InternalDasl.g:1580:3: (enumLiteral_0= 'PHYSICAL' )
                    // InternalDasl.g:1581:4: enumLiteral_0= 'PHYSICAL'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1588:3: (enumLiteral_1= 'VIRTUAL' )
                    {
                    // InternalDasl.g:1588:3: (enumLiteral_1= 'VIRTUAL' )
                    // InternalDasl.g:1589:4: enumLiteral_1= 'VIRTUAL'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1596:3: (enumLiteral_2= 'CONTAINER' )
                    {
                    // InternalDasl.g:1596:3: (enumLiteral_2= 'CONTAINER' )
                    // InternalDasl.g:1597:4: enumLiteral_2= 'CONTAINER'
                    {
                    enumLiteral_2=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getCONTAINEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNodeTypeAccess().getCONTAINEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeType"


    // $ANTLR start "ruleMetadataType"
    // InternalDasl.g:1607:1: ruleMetadataType returns [Enumerator current=null] : ( (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' ) | (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' ) | (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' ) | (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' ) ) ;
    public final Enumerator ruleMetadataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDasl.g:1613:2: ( ( (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' ) | (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' ) | (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' ) | (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' ) ) )
            // InternalDasl.g:1614:2: ( (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' ) | (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' ) | (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' ) | (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' ) )
            {
            // InternalDasl.g:1614:2: ( (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' ) | (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' ) | (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' ) | (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt30=1;
                }
                break;
            case 54:
                {
                alt30=2;
                }
                break;
            case 55:
                {
                alt30=3;
                }
                break;
            case 56:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalDasl.g:1615:3: (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' )
                    {
                    // InternalDasl.g:1615:3: (enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS' )
                    // InternalDasl.g:1616:4: enumLiteral_0= 'SHOW_CONTROLS_ON_COMPONENTS'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getMetadataTypeAccess().getSHOW_CONTROLS_ON_COMPONENTSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMetadataTypeAccess().getSHOW_CONTROLS_ON_COMPONENTSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1623:3: (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' )
                    {
                    // InternalDasl.g:1623:3: (enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS' )
                    // InternalDasl.g:1624:4: enumLiteral_1= 'SHOW_CONTROLS_ON_FLOWS'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getMetadataTypeAccess().getSHOW_CONTROLS_ON_FLOWSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMetadataTypeAccess().getSHOW_CONTROLS_ON_FLOWSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1631:3: (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' )
                    {
                    // InternalDasl.g:1631:3: (enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS' )
                    // InternalDasl.g:1632:4: enumLiteral_2= 'SHOW_ASSETS_ON_FLOWS'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getMetadataTypeAccess().getSHOW_ASSETS_ON_FLOWSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMetadataTypeAccess().getSHOW_ASSETS_ON_FLOWSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1639:3: (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' )
                    {
                    // InternalDasl.g:1639:3: (enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS' )
                    // InternalDasl.g:1640:4: enumLiteral_3= 'SHOW_ASSETS_ON_COMPONENTS'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getMetadataTypeAccess().getSHOW_ASSETS_ON_COMPONENTSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getMetadataTypeAccess().getSHOW_ASSETS_ON_COMPONENTSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadataType"


    // $ANTLR start "ruleNIST80053ARev4_FamilyType"
    // InternalDasl.g:1650:1: ruleNIST80053ARev4_FamilyType returns [Enumerator current=null] : ( (enumLiteral_0= 'ACCESS_CONTROL' ) | (enumLiteral_1= 'AWARENESS_AND_TRAINING' ) | (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' ) | (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' ) | (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' ) | (enumLiteral_5= 'CONTINGENCY_PLANNING' ) | (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' ) | (enumLiteral_7= 'INCIDENT_RESPONSE' ) | (enumLiteral_8= 'MAINTENANCE' ) | (enumLiteral_9= 'MEDIA_PROTECTION' ) | (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' ) | (enumLiteral_11= 'PLANNING' ) | (enumLiteral_12= 'PROGRAM_MANAGEMENT' ) | (enumLiteral_13= 'PERSONNEL_SECURITY' ) | (enumLiteral_14= 'RISK_ASSESSMENT' ) | (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' ) | (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' ) | (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' ) ) ;
    public final Enumerator ruleNIST80053ARev4_FamilyType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;


        	enterRule();

        try {
            // InternalDasl.g:1656:2: ( ( (enumLiteral_0= 'ACCESS_CONTROL' ) | (enumLiteral_1= 'AWARENESS_AND_TRAINING' ) | (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' ) | (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' ) | (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' ) | (enumLiteral_5= 'CONTINGENCY_PLANNING' ) | (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' ) | (enumLiteral_7= 'INCIDENT_RESPONSE' ) | (enumLiteral_8= 'MAINTENANCE' ) | (enumLiteral_9= 'MEDIA_PROTECTION' ) | (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' ) | (enumLiteral_11= 'PLANNING' ) | (enumLiteral_12= 'PROGRAM_MANAGEMENT' ) | (enumLiteral_13= 'PERSONNEL_SECURITY' ) | (enumLiteral_14= 'RISK_ASSESSMENT' ) | (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' ) | (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' ) | (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' ) ) )
            // InternalDasl.g:1657:2: ( (enumLiteral_0= 'ACCESS_CONTROL' ) | (enumLiteral_1= 'AWARENESS_AND_TRAINING' ) | (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' ) | (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' ) | (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' ) | (enumLiteral_5= 'CONTINGENCY_PLANNING' ) | (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' ) | (enumLiteral_7= 'INCIDENT_RESPONSE' ) | (enumLiteral_8= 'MAINTENANCE' ) | (enumLiteral_9= 'MEDIA_PROTECTION' ) | (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' ) | (enumLiteral_11= 'PLANNING' ) | (enumLiteral_12= 'PROGRAM_MANAGEMENT' ) | (enumLiteral_13= 'PERSONNEL_SECURITY' ) | (enumLiteral_14= 'RISK_ASSESSMENT' ) | (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' ) | (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' ) | (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' ) )
            {
            // InternalDasl.g:1657:2: ( (enumLiteral_0= 'ACCESS_CONTROL' ) | (enumLiteral_1= 'AWARENESS_AND_TRAINING' ) | (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' ) | (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' ) | (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' ) | (enumLiteral_5= 'CONTINGENCY_PLANNING' ) | (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' ) | (enumLiteral_7= 'INCIDENT_RESPONSE' ) | (enumLiteral_8= 'MAINTENANCE' ) | (enumLiteral_9= 'MEDIA_PROTECTION' ) | (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' ) | (enumLiteral_11= 'PLANNING' ) | (enumLiteral_12= 'PROGRAM_MANAGEMENT' ) | (enumLiteral_13= 'PERSONNEL_SECURITY' ) | (enumLiteral_14= 'RISK_ASSESSMENT' ) | (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' ) | (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' ) | (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' ) )
            int alt31=18;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt31=1;
                }
                break;
            case 58:
                {
                alt31=2;
                }
                break;
            case 59:
                {
                alt31=3;
                }
                break;
            case 60:
                {
                alt31=4;
                }
                break;
            case 61:
                {
                alt31=5;
                }
                break;
            case 62:
                {
                alt31=6;
                }
                break;
            case 63:
                {
                alt31=7;
                }
                break;
            case 64:
                {
                alt31=8;
                }
                break;
            case 65:
                {
                alt31=9;
                }
                break;
            case 66:
                {
                alt31=10;
                }
                break;
            case 67:
                {
                alt31=11;
                }
                break;
            case 68:
                {
                alt31=12;
                }
                break;
            case 69:
                {
                alt31=13;
                }
                break;
            case 70:
                {
                alt31=14;
                }
                break;
            case 71:
                {
                alt31=15;
                }
                break;
            case 72:
                {
                alt31=16;
                }
                break;
            case 73:
                {
                alt31=17;
                }
                break;
            case 74:
                {
                alt31=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalDasl.g:1658:3: (enumLiteral_0= 'ACCESS_CONTROL' )
                    {
                    // InternalDasl.g:1658:3: (enumLiteral_0= 'ACCESS_CONTROL' )
                    // InternalDasl.g:1659:4: enumLiteral_0= 'ACCESS_CONTROL'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getACCESS_CONTROLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getACCESS_CONTROLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1666:3: (enumLiteral_1= 'AWARENESS_AND_TRAINING' )
                    {
                    // InternalDasl.g:1666:3: (enumLiteral_1= 'AWARENESS_AND_TRAINING' )
                    // InternalDasl.g:1667:4: enumLiteral_1= 'AWARENESS_AND_TRAINING'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getAWARENESS_AND_TRAININGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getAWARENESS_AND_TRAININGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1674:3: (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' )
                    {
                    // InternalDasl.g:1674:3: (enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY' )
                    // InternalDasl.g:1675:4: enumLiteral_2= 'AUDIT_AND_ACCOUNTABILITY'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getAUDIT_AND_ACCOUNTABILITYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getAUDIT_AND_ACCOUNTABILITYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1682:3: (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' )
                    {
                    // InternalDasl.g:1682:3: (enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION' )
                    // InternalDasl.g:1683:4: enumLiteral_3= 'SECURITY_ASSESSMENT_AND_AUTHORIZATION'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSECURITY_ASSESSMENT_AND_AUTHORIZATIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSECURITY_ASSESSMENT_AND_AUTHORIZATIONEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:1690:3: (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' )
                    {
                    // InternalDasl.g:1690:3: (enumLiteral_4= 'CONFIGURATION_MANAGEMENT' )
                    // InternalDasl.g:1691:4: enumLiteral_4= 'CONFIGURATION_MANAGEMENT'
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getCONFIGURATION_MANAGEMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getCONFIGURATION_MANAGEMENTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDasl.g:1698:3: (enumLiteral_5= 'CONTINGENCY_PLANNING' )
                    {
                    // InternalDasl.g:1698:3: (enumLiteral_5= 'CONTINGENCY_PLANNING' )
                    // InternalDasl.g:1699:4: enumLiteral_5= 'CONTINGENCY_PLANNING'
                    {
                    enumLiteral_5=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getCONTINGENCY_PLANNINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getCONTINGENCY_PLANNINGEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDasl.g:1706:3: (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' )
                    {
                    // InternalDasl.g:1706:3: (enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION' )
                    // InternalDasl.g:1707:4: enumLiteral_6= 'IDENTIFICATION_AND_AUTHENTICATION'
                    {
                    enumLiteral_6=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getIDENTIFICATION_AND_AUTHENTICATIONEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getIDENTIFICATION_AND_AUTHENTICATIONEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDasl.g:1714:3: (enumLiteral_7= 'INCIDENT_RESPONSE' )
                    {
                    // InternalDasl.g:1714:3: (enumLiteral_7= 'INCIDENT_RESPONSE' )
                    // InternalDasl.g:1715:4: enumLiteral_7= 'INCIDENT_RESPONSE'
                    {
                    enumLiteral_7=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getINCIDENT_RESPONSEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getINCIDENT_RESPONSEEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDasl.g:1722:3: (enumLiteral_8= 'MAINTENANCE' )
                    {
                    // InternalDasl.g:1722:3: (enumLiteral_8= 'MAINTENANCE' )
                    // InternalDasl.g:1723:4: enumLiteral_8= 'MAINTENANCE'
                    {
                    enumLiteral_8=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getMAINTENANCEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getMAINTENANCEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDasl.g:1730:3: (enumLiteral_9= 'MEDIA_PROTECTION' )
                    {
                    // InternalDasl.g:1730:3: (enumLiteral_9= 'MEDIA_PROTECTION' )
                    // InternalDasl.g:1731:4: enumLiteral_9= 'MEDIA_PROTECTION'
                    {
                    enumLiteral_9=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getMEDIA_PROTECTIONEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getMEDIA_PROTECTIONEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDasl.g:1738:3: (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' )
                    {
                    // InternalDasl.g:1738:3: (enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION' )
                    // InternalDasl.g:1739:4: enumLiteral_10= 'PHYSICAL_AND_ENVIRONMENTAL_PROTECTION'
                    {
                    enumLiteral_10=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPHYSICAL_AND_ENVIRONMENTAL_PROTECTIONEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPHYSICAL_AND_ENVIRONMENTAL_PROTECTIONEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDasl.g:1746:3: (enumLiteral_11= 'PLANNING' )
                    {
                    // InternalDasl.g:1746:3: (enumLiteral_11= 'PLANNING' )
                    // InternalDasl.g:1747:4: enumLiteral_11= 'PLANNING'
                    {
                    enumLiteral_11=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPLANNINGEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPLANNINGEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDasl.g:1754:3: (enumLiteral_12= 'PROGRAM_MANAGEMENT' )
                    {
                    // InternalDasl.g:1754:3: (enumLiteral_12= 'PROGRAM_MANAGEMENT' )
                    // InternalDasl.g:1755:4: enumLiteral_12= 'PROGRAM_MANAGEMENT'
                    {
                    enumLiteral_12=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPROGRAM_MANAGEMENTEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPROGRAM_MANAGEMENTEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDasl.g:1762:3: (enumLiteral_13= 'PERSONNEL_SECURITY' )
                    {
                    // InternalDasl.g:1762:3: (enumLiteral_13= 'PERSONNEL_SECURITY' )
                    // InternalDasl.g:1763:4: enumLiteral_13= 'PERSONNEL_SECURITY'
                    {
                    enumLiteral_13=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPERSONNEL_SECURITYEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getPERSONNEL_SECURITYEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDasl.g:1770:3: (enumLiteral_14= 'RISK_ASSESSMENT' )
                    {
                    // InternalDasl.g:1770:3: (enumLiteral_14= 'RISK_ASSESSMENT' )
                    // InternalDasl.g:1771:4: enumLiteral_14= 'RISK_ASSESSMENT'
                    {
                    enumLiteral_14=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getRISK_ASSESSMENTEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getRISK_ASSESSMENTEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDasl.g:1778:3: (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' )
                    {
                    // InternalDasl.g:1778:3: (enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION' )
                    // InternalDasl.g:1779:4: enumLiteral_15= 'SYSTEM_AND_SERVICES_ACQUISITION'
                    {
                    enumLiteral_15=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_SERVICES_ACQUISITIONEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_SERVICES_ACQUISITIONEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDasl.g:1786:3: (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' )
                    {
                    // InternalDasl.g:1786:3: (enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION' )
                    // InternalDasl.g:1787:4: enumLiteral_16= 'SYSTEM_AND_COMMUNICATIONS_PROTECTION'
                    {
                    enumLiteral_16=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_COMMUNICATIONS_PROTECTIONEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_COMMUNICATIONS_PROTECTIONEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDasl.g:1794:3: (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' )
                    {
                    // InternalDasl.g:1794:3: (enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY' )
                    // InternalDasl.g:1795:4: enumLiteral_17= 'SYSTEM_AND_INFORMATION_INTEGRITY'
                    {
                    enumLiteral_17=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_INFORMATION_INTEGRITYEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getSYSTEM_AND_INFORMATION_INTEGRITYEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNIST80053ARev4_FamilyType"


    // $ANTLR start "ruleConfidentialityType"
    // InternalDasl.g:1805:1: ruleConfidentialityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) ) ;
    public final Enumerator ruleConfidentialityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDasl.g:1811:2: ( ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) ) )
            // InternalDasl.g:1812:2: ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) )
            {
            // InternalDasl.g:1812:2: ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt32=1;
                }
                break;
            case 76:
                {
                alt32=2;
                }
                break;
            case 77:
                {
                alt32=3;
                }
                break;
            case 78:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalDasl.g:1813:3: (enumLiteral_0= 'Public' )
                    {
                    // InternalDasl.g:1813:3: (enumLiteral_0= 'Public' )
                    // InternalDasl.g:1814:4: enumLiteral_0= 'Public'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1821:3: (enumLiteral_1= 'Internal' )
                    {
                    // InternalDasl.g:1821:3: (enumLiteral_1= 'Internal' )
                    // InternalDasl.g:1822:4: enumLiteral_1= 'Internal'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1829:3: (enumLiteral_2= 'Confidential' )
                    {
                    // InternalDasl.g:1829:3: (enumLiteral_2= 'Confidential' )
                    // InternalDasl.g:1830:4: enumLiteral_2= 'Confidential'
                    {
                    enumLiteral_2=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getConfidentialEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getConfidentialityTypeAccess().getConfidentialEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1837:3: (enumLiteral_3= 'Restricted' )
                    {
                    // InternalDasl.g:1837:3: (enumLiteral_3= 'Restricted' )
                    // InternalDasl.g:1838:4: enumLiteral_3= 'Restricted'
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getRestrictedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getConfidentialityTypeAccess().getRestrictedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfidentialityType"


    // $ANTLR start "ruleIntegrityType"
    // InternalDasl.g:1848:1: ruleIntegrityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) ) ;
    public final Enumerator ruleIntegrityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDasl.g:1854:2: ( ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) ) )
            // InternalDasl.g:1855:2: ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) )
            {
            // InternalDasl.g:1855:2: ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt33=1;
                }
                break;
            case 80:
                {
                alt33=2;
                }
                break;
            case 81:
                {
                alt33=3;
                }
                break;
            case 82:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalDasl.g:1856:3: (enumLiteral_0= 'Accurate' )
                    {
                    // InternalDasl.g:1856:3: (enumLiteral_0= 'Accurate' )
                    // InternalDasl.g:1857:4: enumLiteral_0= 'Accurate'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1864:3: (enumLiteral_1= 'HighlyTrusted' )
                    {
                    // InternalDasl.g:1864:3: (enumLiteral_1= 'HighlyTrusted' )
                    // InternalDasl.g:1865:4: enumLiteral_1= 'HighlyTrusted'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1872:3: (enumLiteral_2= 'Trusted' )
                    {
                    // InternalDasl.g:1872:3: (enumLiteral_2= 'Trusted' )
                    // InternalDasl.g:1873:4: enumLiteral_2= 'Trusted'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1880:3: (enumLiteral_3= 'Uncontrolled' )
                    {
                    // InternalDasl.g:1880:3: (enumLiteral_3= 'Uncontrolled' )
                    // InternalDasl.g:1881:4: enumLiteral_3= 'Uncontrolled'
                    {
                    enumLiteral_3=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getUncontrolledEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getIntegrityTypeAccess().getUncontrolledEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegrityType"


    // $ANTLR start "ruleAvailabilityType"
    // InternalDasl.g:1891:1: ruleAvailabilityType returns [Enumerator current=null] : ( (enumLiteral_0= 'C1' ) | (enumLiteral_1= 'C2' ) | (enumLiteral_2= 'C3' ) | (enumLiteral_3= 'C4' ) | (enumLiteral_4= 'Plastic' ) ) ;
    public final Enumerator ruleAvailabilityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalDasl.g:1897:2: ( ( (enumLiteral_0= 'C1' ) | (enumLiteral_1= 'C2' ) | (enumLiteral_2= 'C3' ) | (enumLiteral_3= 'C4' ) | (enumLiteral_4= 'Plastic' ) ) )
            // InternalDasl.g:1898:2: ( (enumLiteral_0= 'C1' ) | (enumLiteral_1= 'C2' ) | (enumLiteral_2= 'C3' ) | (enumLiteral_3= 'C4' ) | (enumLiteral_4= 'Plastic' ) )
            {
            // InternalDasl.g:1898:2: ( (enumLiteral_0= 'C1' ) | (enumLiteral_1= 'C2' ) | (enumLiteral_2= 'C3' ) | (enumLiteral_3= 'C4' ) | (enumLiteral_4= 'Plastic' ) )
            int alt34=5;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt34=1;
                }
                break;
            case 84:
                {
                alt34=2;
                }
                break;
            case 85:
                {
                alt34=3;
                }
                break;
            case 86:
                {
                alt34=4;
                }
                break;
            case 87:
                {
                alt34=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalDasl.g:1899:3: (enumLiteral_0= 'C1' )
                    {
                    // InternalDasl.g:1899:3: (enumLiteral_0= 'C1' )
                    // InternalDasl.g:1900:4: enumLiteral_0= 'C1'
                    {
                    enumLiteral_0=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getC1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAvailabilityTypeAccess().getC1EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1907:3: (enumLiteral_1= 'C2' )
                    {
                    // InternalDasl.g:1907:3: (enumLiteral_1= 'C2' )
                    // InternalDasl.g:1908:4: enumLiteral_1= 'C2'
                    {
                    enumLiteral_1=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getC2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAvailabilityTypeAccess().getC2EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1915:3: (enumLiteral_2= 'C3' )
                    {
                    // InternalDasl.g:1915:3: (enumLiteral_2= 'C3' )
                    // InternalDasl.g:1916:4: enumLiteral_2= 'C3'
                    {
                    enumLiteral_2=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getC3EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAvailabilityTypeAccess().getC3EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1923:3: (enumLiteral_3= 'C4' )
                    {
                    // InternalDasl.g:1923:3: (enumLiteral_3= 'C4' )
                    // InternalDasl.g:1924:4: enumLiteral_3= 'C4'
                    {
                    enumLiteral_3=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getC4EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAvailabilityTypeAccess().getC4EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:1931:3: (enumLiteral_4= 'Plastic' )
                    {
                    // InternalDasl.g:1931:3: (enumLiteral_4= 'Plastic' )
                    // InternalDasl.g:1932:4: enumLiteral_4= 'Plastic'
                    {
                    enumLiteral_4=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getPlasticEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getAvailabilityTypeAccess().getPlasticEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAvailabilityType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00008A4420407002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00008A4420404002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x01E0000000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000300010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000018300000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010300010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010200010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000030300000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020300010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000020200010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000078000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000F80000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008100000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000010300000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xFE00000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000000000000L});

}