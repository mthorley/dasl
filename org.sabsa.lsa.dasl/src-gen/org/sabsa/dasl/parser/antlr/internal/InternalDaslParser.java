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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'import'", "'zone'", "'{'", "'trustLevel'", "'ingress'", "'egress'", "'nodes'", "'controls'", "'}'", "'node'", "'ref'", "'host'", "'os'", "'type'", "'components'", "'component'", "'stereotype'", "'vendor'", "'desc'", "'version'", "'assets'", "'informationasset'", "'confidentiality'", "'integrity'", "'availability'", "'flow'", "'from'", "'to'", "'control'", "'implementation'", "'PHYSICAL'", "'VIRTUAL'", "'CONTAINER'", "'IdentityValidation'", "'UserProvisioning'", "'SystemUserProvisioning'", "'IdentityTransformation'", "'UserRegistries'", "'CredentialManagement'", "'Authentication'", "'Authorisation'", "'PrivilegeManagement'", "'ReducedSignOn'", "'Federation'", "'AccessEntitlementGovernance'", "'FirewallsNetwork'", "'FirewallsApplication'", "'DenialofService'", "'NetworkAdmissionControl'", "'RemoteAccessGateway'", "'IntrusionPreventionDetection'", "'Antivirus'", "'ContentFilter'", "'MessageSecurity'", "'TransportSecurity'", "'StoredDataSecurity'", "'DataLossPrevention'", "'DataObfuscation'", "'DataDestruction'", "'FraudSecurity'", "'DataTransactionSecurity'", "'CentralisedHSM_CA_PKI'", "'Standalone'", "'SecurityTesting'", "'PatchManagement'", "'VulnerabilityManagement'", "'CentralisedReporting'", "'EventCorrelation'", "'SecurityAuditLogMonitoring'", "'ComplianceTesting'", "'IncidentManagement'", "'Forensic'", "'Legal'", "'Public'", "'Internal'", "'Confidential'", "'Restricted'", "'Accurate'", "'HighlyTrusted'", "'Trusted'", "'Uncontrolled'", "'Platinum'", "'Gold'", "'Silver'", "'Bronze'", "'Plastic'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
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
    // InternalDasl.g:72:1: ruleSecurityModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleSecurityModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:78:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalDasl.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalDasl.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)||LA1_0==21||LA1_0==27||LA1_0==33||LA1_0==37||LA1_0==40) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDasl.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalDasl.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalDasl.g:81:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getSecurityModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getSecurityModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.sabsa.dasl.Dasl.AbstractElement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // InternalDasl.g:101:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDasl.g:101:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDasl.g:102:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDasl.g:108:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDasl.g:114:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDasl.g:115:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDasl.g:115:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDasl.g:116:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalDasl.g:123:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDasl.g:124:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,11,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_4); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // InternalDasl.g:141:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDasl.g:141:47: (iv_ruleImport= ruleImport EOF )
            // InternalDasl.g:142:2: iv_ruleImport= ruleImport EOF
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
    // InternalDasl.g:148:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalDasl.g:154:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalDasl.g:155:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalDasl.g:155:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalDasl.g:156:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalDasl.g:160:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalDasl.g:161:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalDasl.g:161:4: (lv_importURI_1_0= RULE_STRING )
            // InternalDasl.g:162:5: lv_importURI_1_0= RULE_STRING
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


    // $ANTLR start "entryRuleZone"
    // InternalDasl.g:182:1: entryRuleZone returns [EObject current=null] : iv_ruleZone= ruleZone EOF ;
    public final EObject entryRuleZone() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleZone = null;


        try {
            // InternalDasl.g:182:45: (iv_ruleZone= ruleZone EOF )
            // InternalDasl.g:183:2: iv_ruleZone= ruleZone EOF
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
    // InternalDasl.g:189:1: ruleZone returns [EObject current=null] : (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) ;
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
            // InternalDasl.g:195:2: ( (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' ) )
            // InternalDasl.g:196:2: (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            {
            // InternalDasl.g:196:2: (otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}' )
            // InternalDasl.g:197:3: otherlv_0= 'zone' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'trustLevel' ( (lv_trust_4_0= RULE_INT ) ) otherlv_5= 'ingress' ( (otherlv_6= RULE_ID ) )* otherlv_7= 'egress' ( (otherlv_8= RULE_ID ) )* otherlv_9= 'nodes' ( (otherlv_10= RULE_ID ) )* (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getZoneAccess().getZoneKeyword_0());
            		
            // InternalDasl.g:201:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:202:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:202:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:203:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getZoneAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getZoneRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getZoneAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getZoneAccess().getTrustLevelKeyword_3());
            		
            // InternalDasl.g:227:3: ( (lv_trust_4_0= RULE_INT ) )
            // InternalDasl.g:228:4: (lv_trust_4_0= RULE_INT )
            {
            // InternalDasl.g:228:4: (lv_trust_4_0= RULE_INT )
            // InternalDasl.g:229:5: lv_trust_4_0= RULE_INT
            {
            lv_trust_4_0=(Token)match(input,RULE_INT,FOLLOW_10); 

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

            otherlv_5=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getZoneAccess().getIngressKeyword_5());
            		
            // InternalDasl.g:249:3: ( (otherlv_6= RULE_ID ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDasl.g:250:4: (otherlv_6= RULE_ID )
            	    {
            	    // InternalDasl.g:250:4: (otherlv_6= RULE_ID )
            	    // InternalDasl.g:251:5: otherlv_6= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    					newLeafNode(otherlv_6, grammarAccess.getZoneAccess().getIngressZonesZoneCrossReference_6_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_7, grammarAccess.getZoneAccess().getEgressKeyword_7());
            		
            // InternalDasl.g:266:3: ( (otherlv_8= RULE_ID ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDasl.g:267:4: (otherlv_8= RULE_ID )
            	    {
            	    // InternalDasl.g:267:4: (otherlv_8= RULE_ID )
            	    // InternalDasl.g:268:5: otherlv_8= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_12); 

            	    					newLeafNode(otherlv_8, grammarAccess.getZoneAccess().getEgressZonesZoneCrossReference_8_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_9=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_9, grammarAccess.getZoneAccess().getNodesKeyword_9());
            		
            // InternalDasl.g:283:3: ( (otherlv_10= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDasl.g:284:4: (otherlv_10= RULE_ID )
            	    {
            	    // InternalDasl.g:284:4: (otherlv_10= RULE_ID )
            	    // InternalDasl.g:285:5: otherlv_10= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getZoneRule());
            	    					}
            	    				
            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    					newLeafNode(otherlv_10, grammarAccess.getZoneAccess().getNodesNodeCrossReference_10_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalDasl.g:296:3: (otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalDasl.g:297:4: otherlv_11= 'controls' ( (otherlv_12= RULE_ID ) )*
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_14); 

                    				newLeafNode(otherlv_11, grammarAccess.getZoneAccess().getControlsKeyword_11_0());
                    			
                    // InternalDasl.g:301:4: ( (otherlv_12= RULE_ID ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalDasl.g:302:5: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalDasl.g:302:5: (otherlv_12= RULE_ID )
                    	    // InternalDasl.g:303:6: otherlv_12= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getZoneRule());
                    	    						}
                    	    					
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_14); 

                    	    						newLeafNode(otherlv_12, grammarAccess.getZoneAccess().getControlsControlCrossReference_11_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

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
    // InternalDasl.g:323:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalDasl.g:323:45: (iv_ruleNode= ruleNode EOF )
            // InternalDasl.g:324:2: iv_ruleNode= ruleNode EOF
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
    // InternalDasl.g:330:1: ruleNode returns [EObject current=null] : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? otherlv_15= '}' ) ;
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
        Enumerator lv_value_10_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:336:2: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? otherlv_15= '}' ) )
            // InternalDasl.g:337:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? otherlv_15= '}' )
            {
            // InternalDasl.g:337:2: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? otherlv_15= '}' )
            // InternalDasl.g:338:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'host' ( (lv_host_6_0= RULE_STRING ) ) otherlv_7= 'os' ( (lv_os_8_0= RULE_STRING ) ) otherlv_9= 'type' ( (lv_value_10_0= ruleNodeType ) ) otherlv_11= 'components' ( (otherlv_12= RULE_ID ) )* (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalDasl.g:342:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:343:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:343:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:344:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getNodeAccess().getRefKeyword_3());
            		
            // InternalDasl.g:368:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:369:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:369:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:370:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getNodeAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getNodeAccess().getHostKeyword_5());
            		
            // InternalDasl.g:390:3: ( (lv_host_6_0= RULE_STRING ) )
            // InternalDasl.g:391:4: (lv_host_6_0= RULE_STRING )
            {
            // InternalDasl.g:391:4: (lv_host_6_0= RULE_STRING )
            // InternalDasl.g:392:5: lv_host_6_0= RULE_STRING
            {
            lv_host_6_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            otherlv_7=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getOsKeyword_7());
            		
            // InternalDasl.g:412:3: ( (lv_os_8_0= RULE_STRING ) )
            // InternalDasl.g:413:4: (lv_os_8_0= RULE_STRING )
            {
            // InternalDasl.g:413:4: (lv_os_8_0= RULE_STRING )
            // InternalDasl.g:414:5: lv_os_8_0= RULE_STRING
            {
            lv_os_8_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

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

            otherlv_9=(Token)match(input,25,FOLLOW_19); 

            			newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getTypeKeyword_9());
            		
            // InternalDasl.g:434:3: ( (lv_value_10_0= ruleNodeType ) )
            // InternalDasl.g:435:4: (lv_value_10_0= ruleNodeType )
            {
            // InternalDasl.g:435:4: (lv_value_10_0= ruleNodeType )
            // InternalDasl.g:436:5: lv_value_10_0= ruleNodeType
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getValueNodeTypeEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_20);
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

            otherlv_11=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_11, grammarAccess.getNodeAccess().getComponentsKeyword_11());
            		
            // InternalDasl.g:457:3: ( (otherlv_12= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDasl.g:458:4: (otherlv_12= RULE_ID )
            	    {
            	    // InternalDasl.g:458:4: (otherlv_12= RULE_ID )
            	    // InternalDasl.g:459:5: otherlv_12= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getNodeRule());
            	    					}
            	    				
            	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    					newLeafNode(otherlv_12, grammarAccess.getNodeAccess().getComponentsComponentCrossReference_12_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalDasl.g:470:3: (otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDasl.g:471:4: otherlv_13= 'controls' ( (otherlv_14= RULE_ID ) )*
                    {
                    otherlv_13=(Token)match(input,19,FOLLOW_14); 

                    				newLeafNode(otherlv_13, grammarAccess.getNodeAccess().getControlsKeyword_13_0());
                    			
                    // InternalDasl.g:475:4: ( (otherlv_14= RULE_ID ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalDasl.g:476:5: (otherlv_14= RULE_ID )
                    	    {
                    	    // InternalDasl.g:476:5: (otherlv_14= RULE_ID )
                    	    // InternalDasl.g:477:6: otherlv_14= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getNodeRule());
                    	    						}
                    	    					
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_14); 

                    	    						newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getControlsControlCrossReference_13_1_0());
                    	    					

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

            otherlv_15=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_14());
            		

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
    // InternalDasl.g:497:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalDasl.g:497:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalDasl.g:498:2: iv_ruleComponent= ruleComponent EOF
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
    // InternalDasl.g:504:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' ) ;
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
            // InternalDasl.g:510:2: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' ) )
            // InternalDasl.g:511:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' )
            {
            // InternalDasl.g:511:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}' )
            // InternalDasl.g:512:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'stereotype' ( (lv_stereotype_6_0= RULE_STRING ) ) (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )? otherlv_9= 'desc' ( (lv_desc_10_0= RULE_STRING ) ) otherlv_11= 'version' ( (lv_version_12_0= RULE_STRING ) ) (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )? ( (lv_components_17_0= ruleComponent ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
            		
            // InternalDasl.g:516:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:517:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:517:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:518:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getComponentAccess().getRefKeyword_3());
            		
            // InternalDasl.g:542:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:543:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:543:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:544:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getComponentAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getComponentAccess().getStereotypeKeyword_5());
            		
            // InternalDasl.g:564:3: ( (lv_stereotype_6_0= RULE_STRING ) )
            // InternalDasl.g:565:4: (lv_stereotype_6_0= RULE_STRING )
            {
            // InternalDasl.g:565:4: (lv_stereotype_6_0= RULE_STRING )
            // InternalDasl.g:566:5: lv_stereotype_6_0= RULE_STRING
            {
            lv_stereotype_6_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

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

            // InternalDasl.g:582:3: (otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDasl.g:583:4: otherlv_7= 'vendor' ( (lv_vendor_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,29,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getComponentAccess().getVendorKeyword_7_0());
                    			
                    // InternalDasl.g:587:4: ( (lv_vendor_8_0= RULE_STRING ) )
                    // InternalDasl.g:588:5: (lv_vendor_8_0= RULE_STRING )
                    {
                    // InternalDasl.g:588:5: (lv_vendor_8_0= RULE_STRING )
                    // InternalDasl.g:589:6: lv_vendor_8_0= RULE_STRING
                    {
                    lv_vendor_8_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

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

            otherlv_9=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getComponentAccess().getDescKeyword_8());
            		
            // InternalDasl.g:610:3: ( (lv_desc_10_0= RULE_STRING ) )
            // InternalDasl.g:611:4: (lv_desc_10_0= RULE_STRING )
            {
            // InternalDasl.g:611:4: (lv_desc_10_0= RULE_STRING )
            // InternalDasl.g:612:5: lv_desc_10_0= RULE_STRING
            {
            lv_desc_10_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

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

            otherlv_11=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_11, grammarAccess.getComponentAccess().getVersionKeyword_10());
            		
            // InternalDasl.g:632:3: ( (lv_version_12_0= RULE_STRING ) )
            // InternalDasl.g:633:4: (lv_version_12_0= RULE_STRING )
            {
            // InternalDasl.g:633:4: (lv_version_12_0= RULE_STRING )
            // InternalDasl.g:634:5: lv_version_12_0= RULE_STRING
            {
            lv_version_12_0=(Token)match(input,RULE_STRING,FOLLOW_25); 

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

            // InternalDasl.g:650:3: (otherlv_13= 'assets' ( ( ruleQualifiedName ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDasl.g:651:4: otherlv_13= 'assets' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,32,FOLLOW_26); 

                    				newLeafNode(otherlv_13, grammarAccess.getComponentAccess().getAssetsKeyword_12_0());
                    			
                    // InternalDasl.g:655:4: ( ( ruleQualifiedName ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalDasl.g:656:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalDasl.g:656:5: ( ruleQualifiedName )
                    	    // InternalDasl.g:657:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getComponentRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getComponentAccess().getAssetsInformationAssetCrossReference_12_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:672:3: (otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDasl.g:673:4: otherlv_15= 'controls' ( (otherlv_16= RULE_ID ) )*
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_27); 

                    				newLeafNode(otherlv_15, grammarAccess.getComponentAccess().getControlsKeyword_13_0());
                    			
                    // InternalDasl.g:677:4: ( (otherlv_16= RULE_ID ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalDasl.g:678:5: (otherlv_16= RULE_ID )
                    	    {
                    	    // InternalDasl.g:678:5: (otherlv_16= RULE_ID )
                    	    // InternalDasl.g:679:6: otherlv_16= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getComponentRule());
                    	    						}
                    	    					
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_27); 

                    	    						newLeafNode(otherlv_16, grammarAccess.getComponentAccess().getControlsControlCrossReference_13_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:691:3: ( (lv_components_17_0= ruleComponent ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDasl.g:692:4: (lv_components_17_0= ruleComponent )
            	    {
            	    // InternalDasl.g:692:4: (lv_components_17_0= ruleComponent )
            	    // InternalDasl.g:693:5: lv_components_17_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getComponentAccess().getComponentsComponentParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_28);
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
            	    break loop16;
                }
            } while (true);

            otherlv_18=(Token)match(input,20,FOLLOW_2); 

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
    // InternalDasl.g:718:1: entryRuleInformationAsset returns [EObject current=null] : iv_ruleInformationAsset= ruleInformationAsset EOF ;
    public final EObject entryRuleInformationAsset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInformationAsset = null;


        try {
            // InternalDasl.g:718:57: (iv_ruleInformationAsset= ruleInformationAsset EOF )
            // InternalDasl.g:719:2: iv_ruleInformationAsset= ruleInformationAsset EOF
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
    // InternalDasl.g:725:1: ruleInformationAsset returns [EObject current=null] : (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' ) ;
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
            // InternalDasl.g:731:2: ( (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' ) )
            // InternalDasl.g:732:2: (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' )
            {
            // InternalDasl.g:732:2: (otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}' )
            // InternalDasl.g:733:3: otherlv_0= 'informationasset' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'desc' ( (lv_desc_6_0= RULE_STRING ) ) otherlv_7= 'confidentiality' ( (lv_confidentiality_8_0= ruleConfidentialityType ) ) otherlv_9= 'integrity' ( (lv_integrity_10_0= ruleIntegrityType ) ) otherlv_11= 'availability' ( (lv_availability_12_0= ruleAvailabilityType ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getInformationAssetAccess().getInformationassetKeyword_0());
            		
            // InternalDasl.g:737:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:738:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:738:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:739:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInformationAssetAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationAssetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getInformationAssetAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getInformationAssetAccess().getRefKeyword_3());
            		
            // InternalDasl.g:763:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:764:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:764:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:765:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getInformationAssetAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInformationAssetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getInformationAssetAccess().getDescKeyword_5());
            		
            // InternalDasl.g:785:3: ( (lv_desc_6_0= RULE_STRING ) )
            // InternalDasl.g:786:4: (lv_desc_6_0= RULE_STRING )
            {
            // InternalDasl.g:786:4: (lv_desc_6_0= RULE_STRING )
            // InternalDasl.g:787:5: lv_desc_6_0= RULE_STRING
            {
            lv_desc_6_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

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

            otherlv_7=(Token)match(input,34,FOLLOW_30); 

            			newLeafNode(otherlv_7, grammarAccess.getInformationAssetAccess().getConfidentialityKeyword_7());
            		
            // InternalDasl.g:807:3: ( (lv_confidentiality_8_0= ruleConfidentialityType ) )
            // InternalDasl.g:808:4: (lv_confidentiality_8_0= ruleConfidentialityType )
            {
            // InternalDasl.g:808:4: (lv_confidentiality_8_0= ruleConfidentialityType )
            // InternalDasl.g:809:5: lv_confidentiality_8_0= ruleConfidentialityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getConfidentialityConfidentialityTypeEnumRuleCall_8_0());
            				
            pushFollow(FOLLOW_31);
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

            otherlv_9=(Token)match(input,35,FOLLOW_32); 

            			newLeafNode(otherlv_9, grammarAccess.getInformationAssetAccess().getIntegrityKeyword_9());
            		
            // InternalDasl.g:830:3: ( (lv_integrity_10_0= ruleIntegrityType ) )
            // InternalDasl.g:831:4: (lv_integrity_10_0= ruleIntegrityType )
            {
            // InternalDasl.g:831:4: (lv_integrity_10_0= ruleIntegrityType )
            // InternalDasl.g:832:5: lv_integrity_10_0= ruleIntegrityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getIntegrityIntegrityTypeEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_33);
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

            otherlv_11=(Token)match(input,36,FOLLOW_34); 

            			newLeafNode(otherlv_11, grammarAccess.getInformationAssetAccess().getAvailabilityKeyword_11());
            		
            // InternalDasl.g:853:3: ( (lv_availability_12_0= ruleAvailabilityType ) )
            // InternalDasl.g:854:4: (lv_availability_12_0= ruleAvailabilityType )
            {
            // InternalDasl.g:854:4: (lv_availability_12_0= ruleAvailabilityType )
            // InternalDasl.g:855:5: lv_availability_12_0= ruleAvailabilityType
            {

            					newCompositeNode(grammarAccess.getInformationAssetAccess().getAvailabilityAvailabilityTypeEnumRuleCall_12_0());
            				
            pushFollow(FOLLOW_35);
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

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

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
    // InternalDasl.g:880:1: entryRuleFlow returns [EObject current=null] : iv_ruleFlow= ruleFlow EOF ;
    public final EObject entryRuleFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlow = null;


        try {
            // InternalDasl.g:880:45: (iv_ruleFlow= ruleFlow EOF )
            // InternalDasl.g:881:2: iv_ruleFlow= ruleFlow EOF
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
    // InternalDasl.g:887:1: ruleFlow returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleFlow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;


        	enterRule();

        try {
            // InternalDasl.g:893:2: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )? otherlv_11= '}' ) )
            // InternalDasl.g:894:2: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )? otherlv_11= '}' )
            {
            // InternalDasl.g:894:2: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )? otherlv_11= '}' )
            // InternalDasl.g:895:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )? (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFlowAccess().getFlowKeyword_0());
            		
            // InternalDasl.g:899:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:900:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:900:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:901:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFlowAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getFlowAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,38,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getFlowAccess().getFromKeyword_3());
            		
            // InternalDasl.g:925:3: ( (otherlv_4= RULE_ID ) )
            // InternalDasl.g:926:4: (otherlv_4= RULE_ID )
            {
            // InternalDasl.g:926:4: (otherlv_4= RULE_ID )
            // InternalDasl.g:927:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_4, grammarAccess.getFlowAccess().getFromComponentCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getFlowAccess().getToKeyword_5());
            		
            // InternalDasl.g:942:3: ( (otherlv_6= RULE_ID ) )
            // InternalDasl.g:943:4: (otherlv_6= RULE_ID )
            {
            // InternalDasl.g:943:4: (otherlv_6= RULE_ID )
            // InternalDasl.g:944:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_6, grammarAccess.getFlowAccess().getToComponentCrossReference_6_0());
            				

            }


            }

            // InternalDasl.g:955:3: (otherlv_7= 'assets' ( ( ruleQualifiedName ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDasl.g:956:4: otherlv_7= 'assets' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_7=(Token)match(input,32,FOLLOW_13); 

                    				newLeafNode(otherlv_7, grammarAccess.getFlowAccess().getAssetsKeyword_7_0());
                    			
                    // InternalDasl.g:960:4: ( ( ruleQualifiedName ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalDasl.g:961:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalDasl.g:961:5: ( ruleQualifiedName )
                    	    // InternalDasl.g:962:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getFlowRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getFlowAccess().getAssetsInformationAssetCrossReference_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDasl.g:977:3: (otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDasl.g:978:4: otherlv_9= 'controls' ( (otherlv_10= RULE_ID ) )*
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getFlowAccess().getControlsKeyword_8_0());
                    			
                    // InternalDasl.g:982:4: ( (otherlv_10= RULE_ID ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalDasl.g:983:5: (otherlv_10= RULE_ID )
                    	    {
                    	    // InternalDasl.g:983:5: (otherlv_10= RULE_ID )
                    	    // InternalDasl.g:984:6: otherlv_10= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getFlowRule());
                    	    						}
                    	    					
                    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_14); 

                    	    						newLeafNode(otherlv_10, grammarAccess.getFlowAccess().getControlsControlCrossReference_8_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getFlowAccess().getRightCurlyBracketKeyword_9());
            		

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


    // $ANTLR start "entryRuleControl"
    // InternalDasl.g:1004:1: entryRuleControl returns [EObject current=null] : iv_ruleControl= ruleControl EOF ;
    public final EObject entryRuleControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControl = null;


        try {
            // InternalDasl.g:1004:48: (iv_ruleControl= ruleControl EOF )
            // InternalDasl.g:1005:2: iv_ruleControl= ruleControl EOF
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
    // InternalDasl.g:1011:1: ruleControl returns [EObject current=null] : (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_area_6_0= ruleControlType ) ) otherlv_7= 'implementation' ( (lv_implementation_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_ref_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_implementation_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_area_6_0 = null;



        	enterRule();

        try {
            // InternalDasl.g:1017:2: ( (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_area_6_0= ruleControlType ) ) otherlv_7= 'implementation' ( (lv_implementation_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // InternalDasl.g:1018:2: (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_area_6_0= ruleControlType ) ) otherlv_7= 'implementation' ( (lv_implementation_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // InternalDasl.g:1018:2: (otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_area_6_0= ruleControlType ) ) otherlv_7= 'implementation' ( (lv_implementation_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // InternalDasl.g:1019:3: otherlv_0= 'control' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'ref' ( (lv_ref_4_0= RULE_ID ) ) otherlv_5= 'type' ( (lv_area_6_0= ruleControlType ) ) otherlv_7= 'implementation' ( (lv_implementation_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getControlAccess().getControlKeyword_0());
            		
            // InternalDasl.g:1023:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDasl.g:1024:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDasl.g:1024:4: (lv_name_1_0= RULE_ID )
            // InternalDasl.g:1025:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getControlAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getControlAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getControlAccess().getRefKeyword_3());
            		
            // InternalDasl.g:1049:3: ( (lv_ref_4_0= RULE_ID ) )
            // InternalDasl.g:1050:4: (lv_ref_4_0= RULE_ID )
            {
            // InternalDasl.g:1050:4: (lv_ref_4_0= RULE_ID )
            // InternalDasl.g:1051:5: lv_ref_4_0= RULE_ID
            {
            lv_ref_4_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_ref_4_0, grammarAccess.getControlAccess().getRefIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"ref",
            						lv_ref_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_39); 

            			newLeafNode(otherlv_5, grammarAccess.getControlAccess().getTypeKeyword_5());
            		
            // InternalDasl.g:1071:3: ( (lv_area_6_0= ruleControlType ) )
            // InternalDasl.g:1072:4: (lv_area_6_0= ruleControlType )
            {
            // InternalDasl.g:1072:4: (lv_area_6_0= ruleControlType )
            // InternalDasl.g:1073:5: lv_area_6_0= ruleControlType
            {

            					newCompositeNode(grammarAccess.getControlAccess().getAreaControlTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_40);
            lv_area_6_0=ruleControlType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getControlRule());
            					}
            					set(
            						current,
            						"area",
            						lv_area_6_0,
            						"org.sabsa.dasl.Dasl.ControlType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,41,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getControlAccess().getImplementationKeyword_7());
            		
            // InternalDasl.g:1094:3: ( (lv_implementation_8_0= RULE_STRING ) )
            // InternalDasl.g:1095:4: (lv_implementation_8_0= RULE_STRING )
            {
            // InternalDasl.g:1095:4: (lv_implementation_8_0= RULE_STRING )
            // InternalDasl.g:1096:5: lv_implementation_8_0= RULE_STRING
            {
            lv_implementation_8_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

            					newLeafNode(lv_implementation_8_0, grammarAccess.getControlAccess().getImplementationSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getControlRule());
            					}
            					setWithLastConsumed(
            						current,
            						"implementation",
            						lv_implementation_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getControlAccess().getRightCurlyBracketKeyword_9());
            		

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


    // $ANTLR start "entryRuleAbstractElement"
    // InternalDasl.g:1120:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalDasl.g:1120:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalDasl.g:1121:2: iv_ruleAbstractElement= ruleAbstractElement EOF
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
    // InternalDasl.g:1127:1: ruleAbstractElement returns [EObject current=null] : (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Control_4= ruleControl | this_Flow_5= ruleFlow | this_Import_6= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_InformationAsset_0 = null;

        EObject this_Component_1 = null;

        EObject this_Zone_2 = null;

        EObject this_Node_3 = null;

        EObject this_Control_4 = null;

        EObject this_Flow_5 = null;

        EObject this_Import_6 = null;



        	enterRule();

        try {
            // InternalDasl.g:1133:2: ( (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Control_4= ruleControl | this_Flow_5= ruleFlow | this_Import_6= ruleImport ) )
            // InternalDasl.g:1134:2: (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Control_4= ruleControl | this_Flow_5= ruleFlow | this_Import_6= ruleImport )
            {
            // InternalDasl.g:1134:2: (this_InformationAsset_0= ruleInformationAsset | this_Component_1= ruleComponent | this_Zone_2= ruleZone | this_Node_3= ruleNode | this_Control_4= ruleControl | this_Flow_5= ruleFlow | this_Import_6= ruleImport )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt21=1;
                }
                break;
            case 27:
                {
                alt21=2;
                }
                break;
            case 13:
                {
                alt21=3;
                }
                break;
            case 21:
                {
                alt21=4;
                }
                break;
            case 40:
                {
                alt21=5;
                }
                break;
            case 37:
                {
                alt21=6;
                }
                break;
            case 12:
                {
                alt21=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalDasl.g:1135:3: this_InformationAsset_0= ruleInformationAsset
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
                    // InternalDasl.g:1144:3: this_Component_1= ruleComponent
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
                    // InternalDasl.g:1153:3: this_Zone_2= ruleZone
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
                    // InternalDasl.g:1162:3: this_Node_3= ruleNode
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
                    // InternalDasl.g:1171:3: this_Control_4= ruleControl
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getControlParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Control_4=ruleControl();

                    state._fsp--;


                    			current = this_Control_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDasl.g:1180:3: this_Flow_5= ruleFlow
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getFlowParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Flow_5=ruleFlow();

                    state._fsp--;


                    			current = this_Flow_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalDasl.g:1189:3: this_Import_6= ruleImport
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Import_6=ruleImport();

                    state._fsp--;


                    			current = this_Import_6;
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
    // InternalDasl.g:1201:1: ruleNodeType returns [Enumerator current=null] : ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) ) ;
    public final Enumerator ruleNodeType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalDasl.g:1207:2: ( ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) ) )
            // InternalDasl.g:1208:2: ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) )
            {
            // InternalDasl.g:1208:2: ( (enumLiteral_0= 'PHYSICAL' ) | (enumLiteral_1= 'VIRTUAL' ) | (enumLiteral_2= 'CONTAINER' ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt22=1;
                }
                break;
            case 43:
                {
                alt22=2;
                }
                break;
            case 44:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalDasl.g:1209:3: (enumLiteral_0= 'PHYSICAL' )
                    {
                    // InternalDasl.g:1209:3: (enumLiteral_0= 'PHYSICAL' )
                    // InternalDasl.g:1210:4: enumLiteral_0= 'PHYSICAL'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1217:3: (enumLiteral_1= 'VIRTUAL' )
                    {
                    // InternalDasl.g:1217:3: (enumLiteral_1= 'VIRTUAL' )
                    // InternalDasl.g:1218:4: enumLiteral_1= 'VIRTUAL'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1225:3: (enumLiteral_2= 'CONTAINER' )
                    {
                    // InternalDasl.g:1225:3: (enumLiteral_2= 'CONTAINER' )
                    // InternalDasl.g:1226:4: enumLiteral_2= 'CONTAINER'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); 

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


    // $ANTLR start "ruleControlType"
    // InternalDasl.g:1236:1: ruleControlType returns [Enumerator current=null] : ( (enumLiteral_0= 'IdentityValidation' ) | (enumLiteral_1= 'UserProvisioning' ) | (enumLiteral_2= 'SystemUserProvisioning' ) | (enumLiteral_3= 'IdentityTransformation' ) | (enumLiteral_4= 'UserRegistries' ) | (enumLiteral_5= 'CredentialManagement' ) | (enumLiteral_6= 'Authentication' ) | (enumLiteral_7= 'Authorisation' ) | (enumLiteral_8= 'PrivilegeManagement' ) | (enumLiteral_9= 'ReducedSignOn' ) | (enumLiteral_10= 'Federation' ) | (enumLiteral_11= 'AccessEntitlementGovernance' ) | (enumLiteral_12= 'FirewallsNetwork' ) | (enumLiteral_13= 'FirewallsApplication' ) | (enumLiteral_14= 'DenialofService' ) | (enumLiteral_15= 'NetworkAdmissionControl' ) | (enumLiteral_16= 'RemoteAccessGateway' ) | (enumLiteral_17= 'IntrusionPreventionDetection' ) | (enumLiteral_18= 'Antivirus' ) | (enumLiteral_19= 'ContentFilter' ) | (enumLiteral_20= 'MessageSecurity' ) | (enumLiteral_21= 'TransportSecurity' ) | (enumLiteral_22= 'StoredDataSecurity' ) | (enumLiteral_23= 'DataLossPrevention' ) | (enumLiteral_24= 'DataObfuscation' ) | (enumLiteral_25= 'DataDestruction' ) | (enumLiteral_26= 'FraudSecurity' ) | (enumLiteral_27= 'DataTransactionSecurity' ) | (enumLiteral_28= 'CentralisedHSM_CA_PKI' ) | (enumLiteral_29= 'Standalone' ) | (enumLiteral_30= 'SecurityTesting' ) | (enumLiteral_31= 'PatchManagement' ) | (enumLiteral_32= 'VulnerabilityManagement' ) | (enumLiteral_33= 'CentralisedReporting' ) | (enumLiteral_34= 'EventCorrelation' ) | (enumLiteral_35= 'SecurityAuditLogMonitoring' ) | (enumLiteral_36= 'ComplianceTesting' ) | (enumLiteral_37= 'IncidentManagement' ) | (enumLiteral_38= 'Forensic' ) | (enumLiteral_39= 'Legal' ) ) ;
    public final Enumerator ruleControlType() throws RecognitionException {
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
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;
        Token enumLiteral_37=null;
        Token enumLiteral_38=null;
        Token enumLiteral_39=null;


        	enterRule();

        try {
            // InternalDasl.g:1242:2: ( ( (enumLiteral_0= 'IdentityValidation' ) | (enumLiteral_1= 'UserProvisioning' ) | (enumLiteral_2= 'SystemUserProvisioning' ) | (enumLiteral_3= 'IdentityTransformation' ) | (enumLiteral_4= 'UserRegistries' ) | (enumLiteral_5= 'CredentialManagement' ) | (enumLiteral_6= 'Authentication' ) | (enumLiteral_7= 'Authorisation' ) | (enumLiteral_8= 'PrivilegeManagement' ) | (enumLiteral_9= 'ReducedSignOn' ) | (enumLiteral_10= 'Federation' ) | (enumLiteral_11= 'AccessEntitlementGovernance' ) | (enumLiteral_12= 'FirewallsNetwork' ) | (enumLiteral_13= 'FirewallsApplication' ) | (enumLiteral_14= 'DenialofService' ) | (enumLiteral_15= 'NetworkAdmissionControl' ) | (enumLiteral_16= 'RemoteAccessGateway' ) | (enumLiteral_17= 'IntrusionPreventionDetection' ) | (enumLiteral_18= 'Antivirus' ) | (enumLiteral_19= 'ContentFilter' ) | (enumLiteral_20= 'MessageSecurity' ) | (enumLiteral_21= 'TransportSecurity' ) | (enumLiteral_22= 'StoredDataSecurity' ) | (enumLiteral_23= 'DataLossPrevention' ) | (enumLiteral_24= 'DataObfuscation' ) | (enumLiteral_25= 'DataDestruction' ) | (enumLiteral_26= 'FraudSecurity' ) | (enumLiteral_27= 'DataTransactionSecurity' ) | (enumLiteral_28= 'CentralisedHSM_CA_PKI' ) | (enumLiteral_29= 'Standalone' ) | (enumLiteral_30= 'SecurityTesting' ) | (enumLiteral_31= 'PatchManagement' ) | (enumLiteral_32= 'VulnerabilityManagement' ) | (enumLiteral_33= 'CentralisedReporting' ) | (enumLiteral_34= 'EventCorrelation' ) | (enumLiteral_35= 'SecurityAuditLogMonitoring' ) | (enumLiteral_36= 'ComplianceTesting' ) | (enumLiteral_37= 'IncidentManagement' ) | (enumLiteral_38= 'Forensic' ) | (enumLiteral_39= 'Legal' ) ) )
            // InternalDasl.g:1243:2: ( (enumLiteral_0= 'IdentityValidation' ) | (enumLiteral_1= 'UserProvisioning' ) | (enumLiteral_2= 'SystemUserProvisioning' ) | (enumLiteral_3= 'IdentityTransformation' ) | (enumLiteral_4= 'UserRegistries' ) | (enumLiteral_5= 'CredentialManagement' ) | (enumLiteral_6= 'Authentication' ) | (enumLiteral_7= 'Authorisation' ) | (enumLiteral_8= 'PrivilegeManagement' ) | (enumLiteral_9= 'ReducedSignOn' ) | (enumLiteral_10= 'Federation' ) | (enumLiteral_11= 'AccessEntitlementGovernance' ) | (enumLiteral_12= 'FirewallsNetwork' ) | (enumLiteral_13= 'FirewallsApplication' ) | (enumLiteral_14= 'DenialofService' ) | (enumLiteral_15= 'NetworkAdmissionControl' ) | (enumLiteral_16= 'RemoteAccessGateway' ) | (enumLiteral_17= 'IntrusionPreventionDetection' ) | (enumLiteral_18= 'Antivirus' ) | (enumLiteral_19= 'ContentFilter' ) | (enumLiteral_20= 'MessageSecurity' ) | (enumLiteral_21= 'TransportSecurity' ) | (enumLiteral_22= 'StoredDataSecurity' ) | (enumLiteral_23= 'DataLossPrevention' ) | (enumLiteral_24= 'DataObfuscation' ) | (enumLiteral_25= 'DataDestruction' ) | (enumLiteral_26= 'FraudSecurity' ) | (enumLiteral_27= 'DataTransactionSecurity' ) | (enumLiteral_28= 'CentralisedHSM_CA_PKI' ) | (enumLiteral_29= 'Standalone' ) | (enumLiteral_30= 'SecurityTesting' ) | (enumLiteral_31= 'PatchManagement' ) | (enumLiteral_32= 'VulnerabilityManagement' ) | (enumLiteral_33= 'CentralisedReporting' ) | (enumLiteral_34= 'EventCorrelation' ) | (enumLiteral_35= 'SecurityAuditLogMonitoring' ) | (enumLiteral_36= 'ComplianceTesting' ) | (enumLiteral_37= 'IncidentManagement' ) | (enumLiteral_38= 'Forensic' ) | (enumLiteral_39= 'Legal' ) )
            {
            // InternalDasl.g:1243:2: ( (enumLiteral_0= 'IdentityValidation' ) | (enumLiteral_1= 'UserProvisioning' ) | (enumLiteral_2= 'SystemUserProvisioning' ) | (enumLiteral_3= 'IdentityTransformation' ) | (enumLiteral_4= 'UserRegistries' ) | (enumLiteral_5= 'CredentialManagement' ) | (enumLiteral_6= 'Authentication' ) | (enumLiteral_7= 'Authorisation' ) | (enumLiteral_8= 'PrivilegeManagement' ) | (enumLiteral_9= 'ReducedSignOn' ) | (enumLiteral_10= 'Federation' ) | (enumLiteral_11= 'AccessEntitlementGovernance' ) | (enumLiteral_12= 'FirewallsNetwork' ) | (enumLiteral_13= 'FirewallsApplication' ) | (enumLiteral_14= 'DenialofService' ) | (enumLiteral_15= 'NetworkAdmissionControl' ) | (enumLiteral_16= 'RemoteAccessGateway' ) | (enumLiteral_17= 'IntrusionPreventionDetection' ) | (enumLiteral_18= 'Antivirus' ) | (enumLiteral_19= 'ContentFilter' ) | (enumLiteral_20= 'MessageSecurity' ) | (enumLiteral_21= 'TransportSecurity' ) | (enumLiteral_22= 'StoredDataSecurity' ) | (enumLiteral_23= 'DataLossPrevention' ) | (enumLiteral_24= 'DataObfuscation' ) | (enumLiteral_25= 'DataDestruction' ) | (enumLiteral_26= 'FraudSecurity' ) | (enumLiteral_27= 'DataTransactionSecurity' ) | (enumLiteral_28= 'CentralisedHSM_CA_PKI' ) | (enumLiteral_29= 'Standalone' ) | (enumLiteral_30= 'SecurityTesting' ) | (enumLiteral_31= 'PatchManagement' ) | (enumLiteral_32= 'VulnerabilityManagement' ) | (enumLiteral_33= 'CentralisedReporting' ) | (enumLiteral_34= 'EventCorrelation' ) | (enumLiteral_35= 'SecurityAuditLogMonitoring' ) | (enumLiteral_36= 'ComplianceTesting' ) | (enumLiteral_37= 'IncidentManagement' ) | (enumLiteral_38= 'Forensic' ) | (enumLiteral_39= 'Legal' ) )
            int alt23=40;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt23=1;
                }
                break;
            case 46:
                {
                alt23=2;
                }
                break;
            case 47:
                {
                alt23=3;
                }
                break;
            case 48:
                {
                alt23=4;
                }
                break;
            case 49:
                {
                alt23=5;
                }
                break;
            case 50:
                {
                alt23=6;
                }
                break;
            case 51:
                {
                alt23=7;
                }
                break;
            case 52:
                {
                alt23=8;
                }
                break;
            case 53:
                {
                alt23=9;
                }
                break;
            case 54:
                {
                alt23=10;
                }
                break;
            case 55:
                {
                alt23=11;
                }
                break;
            case 56:
                {
                alt23=12;
                }
                break;
            case 57:
                {
                alt23=13;
                }
                break;
            case 58:
                {
                alt23=14;
                }
                break;
            case 59:
                {
                alt23=15;
                }
                break;
            case 60:
                {
                alt23=16;
                }
                break;
            case 61:
                {
                alt23=17;
                }
                break;
            case 62:
                {
                alt23=18;
                }
                break;
            case 63:
                {
                alt23=19;
                }
                break;
            case 64:
                {
                alt23=20;
                }
                break;
            case 65:
                {
                alt23=21;
                }
                break;
            case 66:
                {
                alt23=22;
                }
                break;
            case 67:
                {
                alt23=23;
                }
                break;
            case 68:
                {
                alt23=24;
                }
                break;
            case 69:
                {
                alt23=25;
                }
                break;
            case 70:
                {
                alt23=26;
                }
                break;
            case 71:
                {
                alt23=27;
                }
                break;
            case 72:
                {
                alt23=28;
                }
                break;
            case 73:
                {
                alt23=29;
                }
                break;
            case 74:
                {
                alt23=30;
                }
                break;
            case 75:
                {
                alt23=31;
                }
                break;
            case 76:
                {
                alt23=32;
                }
                break;
            case 77:
                {
                alt23=33;
                }
                break;
            case 78:
                {
                alt23=34;
                }
                break;
            case 79:
                {
                alt23=35;
                }
                break;
            case 80:
                {
                alt23=36;
                }
                break;
            case 81:
                {
                alt23=37;
                }
                break;
            case 82:
                {
                alt23=38;
                }
                break;
            case 83:
                {
                alt23=39;
                }
                break;
            case 84:
                {
                alt23=40;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalDasl.g:1244:3: (enumLiteral_0= 'IdentityValidation' )
                    {
                    // InternalDasl.g:1244:3: (enumLiteral_0= 'IdentityValidation' )
                    // InternalDasl.g:1245:4: enumLiteral_0= 'IdentityValidation'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getIdentityValidationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getControlTypeAccess().getIdentityValidationEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1252:3: (enumLiteral_1= 'UserProvisioning' )
                    {
                    // InternalDasl.g:1252:3: (enumLiteral_1= 'UserProvisioning' )
                    // InternalDasl.g:1253:4: enumLiteral_1= 'UserProvisioning'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getUserProvisioningEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getControlTypeAccess().getUserProvisioningEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1260:3: (enumLiteral_2= 'SystemUserProvisioning' )
                    {
                    // InternalDasl.g:1260:3: (enumLiteral_2= 'SystemUserProvisioning' )
                    // InternalDasl.g:1261:4: enumLiteral_2= 'SystemUserProvisioning'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getSystemUserProvisioningEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getControlTypeAccess().getSystemUserProvisioningEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1268:3: (enumLiteral_3= 'IdentityTransformation' )
                    {
                    // InternalDasl.g:1268:3: (enumLiteral_3= 'IdentityTransformation' )
                    // InternalDasl.g:1269:4: enumLiteral_3= 'IdentityTransformation'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getIdentityTransformationEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getControlTypeAccess().getIdentityTransformationEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:1276:3: (enumLiteral_4= 'UserRegistries' )
                    {
                    // InternalDasl.g:1276:3: (enumLiteral_4= 'UserRegistries' )
                    // InternalDasl.g:1277:4: enumLiteral_4= 'UserRegistries'
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getUserRegistriesEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getControlTypeAccess().getUserRegistriesEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDasl.g:1284:3: (enumLiteral_5= 'CredentialManagement' )
                    {
                    // InternalDasl.g:1284:3: (enumLiteral_5= 'CredentialManagement' )
                    // InternalDasl.g:1285:4: enumLiteral_5= 'CredentialManagement'
                    {
                    enumLiteral_5=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getCredentialManagementEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getControlTypeAccess().getCredentialManagementEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDasl.g:1292:3: (enumLiteral_6= 'Authentication' )
                    {
                    // InternalDasl.g:1292:3: (enumLiteral_6= 'Authentication' )
                    // InternalDasl.g:1293:4: enumLiteral_6= 'Authentication'
                    {
                    enumLiteral_6=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getAuthenticationEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getControlTypeAccess().getAuthenticationEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDasl.g:1300:3: (enumLiteral_7= 'Authorisation' )
                    {
                    // InternalDasl.g:1300:3: (enumLiteral_7= 'Authorisation' )
                    // InternalDasl.g:1301:4: enumLiteral_7= 'Authorisation'
                    {
                    enumLiteral_7=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getAuthorisationEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getControlTypeAccess().getAuthorisationEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDasl.g:1308:3: (enumLiteral_8= 'PrivilegeManagement' )
                    {
                    // InternalDasl.g:1308:3: (enumLiteral_8= 'PrivilegeManagement' )
                    // InternalDasl.g:1309:4: enumLiteral_8= 'PrivilegeManagement'
                    {
                    enumLiteral_8=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getPrivilegeManagementEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getControlTypeAccess().getPrivilegeManagementEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDasl.g:1316:3: (enumLiteral_9= 'ReducedSignOn' )
                    {
                    // InternalDasl.g:1316:3: (enumLiteral_9= 'ReducedSignOn' )
                    // InternalDasl.g:1317:4: enumLiteral_9= 'ReducedSignOn'
                    {
                    enumLiteral_9=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getReducedSignOnEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getControlTypeAccess().getReducedSignOnEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDasl.g:1324:3: (enumLiteral_10= 'Federation' )
                    {
                    // InternalDasl.g:1324:3: (enumLiteral_10= 'Federation' )
                    // InternalDasl.g:1325:4: enumLiteral_10= 'Federation'
                    {
                    enumLiteral_10=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getFederationEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getControlTypeAccess().getFederationEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDasl.g:1332:3: (enumLiteral_11= 'AccessEntitlementGovernance' )
                    {
                    // InternalDasl.g:1332:3: (enumLiteral_11= 'AccessEntitlementGovernance' )
                    // InternalDasl.g:1333:4: enumLiteral_11= 'AccessEntitlementGovernance'
                    {
                    enumLiteral_11=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getAccessEntitlementGovernanceEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getControlTypeAccess().getAccessEntitlementGovernanceEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDasl.g:1340:3: (enumLiteral_12= 'FirewallsNetwork' )
                    {
                    // InternalDasl.g:1340:3: (enumLiteral_12= 'FirewallsNetwork' )
                    // InternalDasl.g:1341:4: enumLiteral_12= 'FirewallsNetwork'
                    {
                    enumLiteral_12=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getFirewallsNetworkEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getControlTypeAccess().getFirewallsNetworkEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDasl.g:1348:3: (enumLiteral_13= 'FirewallsApplication' )
                    {
                    // InternalDasl.g:1348:3: (enumLiteral_13= 'FirewallsApplication' )
                    // InternalDasl.g:1349:4: enumLiteral_13= 'FirewallsApplication'
                    {
                    enumLiteral_13=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getFirewallsApplicationEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getControlTypeAccess().getFirewallsApplicationEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDasl.g:1356:3: (enumLiteral_14= 'DenialofService' )
                    {
                    // InternalDasl.g:1356:3: (enumLiteral_14= 'DenialofService' )
                    // InternalDasl.g:1357:4: enumLiteral_14= 'DenialofService'
                    {
                    enumLiteral_14=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getDenialofServiceEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getControlTypeAccess().getDenialofServiceEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDasl.g:1364:3: (enumLiteral_15= 'NetworkAdmissionControl' )
                    {
                    // InternalDasl.g:1364:3: (enumLiteral_15= 'NetworkAdmissionControl' )
                    // InternalDasl.g:1365:4: enumLiteral_15= 'NetworkAdmissionControl'
                    {
                    enumLiteral_15=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getNetworkAdmissionControlEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getControlTypeAccess().getNetworkAdmissionControlEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDasl.g:1372:3: (enumLiteral_16= 'RemoteAccessGateway' )
                    {
                    // InternalDasl.g:1372:3: (enumLiteral_16= 'RemoteAccessGateway' )
                    // InternalDasl.g:1373:4: enumLiteral_16= 'RemoteAccessGateway'
                    {
                    enumLiteral_16=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getRemoteAccessGatewayEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getControlTypeAccess().getRemoteAccessGatewayEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDasl.g:1380:3: (enumLiteral_17= 'IntrusionPreventionDetection' )
                    {
                    // InternalDasl.g:1380:3: (enumLiteral_17= 'IntrusionPreventionDetection' )
                    // InternalDasl.g:1381:4: enumLiteral_17= 'IntrusionPreventionDetection'
                    {
                    enumLiteral_17=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getIntrusionPreventionDetectionEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getControlTypeAccess().getIntrusionPreventionDetectionEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDasl.g:1388:3: (enumLiteral_18= 'Antivirus' )
                    {
                    // InternalDasl.g:1388:3: (enumLiteral_18= 'Antivirus' )
                    // InternalDasl.g:1389:4: enumLiteral_18= 'Antivirus'
                    {
                    enumLiteral_18=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getAntivirusEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getControlTypeAccess().getAntivirusEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDasl.g:1396:3: (enumLiteral_19= 'ContentFilter' )
                    {
                    // InternalDasl.g:1396:3: (enumLiteral_19= 'ContentFilter' )
                    // InternalDasl.g:1397:4: enumLiteral_19= 'ContentFilter'
                    {
                    enumLiteral_19=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getContentFilterEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getControlTypeAccess().getContentFilterEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDasl.g:1404:3: (enumLiteral_20= 'MessageSecurity' )
                    {
                    // InternalDasl.g:1404:3: (enumLiteral_20= 'MessageSecurity' )
                    // InternalDasl.g:1405:4: enumLiteral_20= 'MessageSecurity'
                    {
                    enumLiteral_20=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getMessageSecurityEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getControlTypeAccess().getMessageSecurityEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDasl.g:1412:3: (enumLiteral_21= 'TransportSecurity' )
                    {
                    // InternalDasl.g:1412:3: (enumLiteral_21= 'TransportSecurity' )
                    // InternalDasl.g:1413:4: enumLiteral_21= 'TransportSecurity'
                    {
                    enumLiteral_21=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getTransportSecurityEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getControlTypeAccess().getTransportSecurityEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDasl.g:1420:3: (enumLiteral_22= 'StoredDataSecurity' )
                    {
                    // InternalDasl.g:1420:3: (enumLiteral_22= 'StoredDataSecurity' )
                    // InternalDasl.g:1421:4: enumLiteral_22= 'StoredDataSecurity'
                    {
                    enumLiteral_22=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getStoredDataSecurityEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getControlTypeAccess().getStoredDataSecurityEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDasl.g:1428:3: (enumLiteral_23= 'DataLossPrevention' )
                    {
                    // InternalDasl.g:1428:3: (enumLiteral_23= 'DataLossPrevention' )
                    // InternalDasl.g:1429:4: enumLiteral_23= 'DataLossPrevention'
                    {
                    enumLiteral_23=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getDataLossPreventionEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getControlTypeAccess().getDataLossPreventionEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDasl.g:1436:3: (enumLiteral_24= 'DataObfuscation' )
                    {
                    // InternalDasl.g:1436:3: (enumLiteral_24= 'DataObfuscation' )
                    // InternalDasl.g:1437:4: enumLiteral_24= 'DataObfuscation'
                    {
                    enumLiteral_24=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getDataObfuscationEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getControlTypeAccess().getDataObfuscationEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDasl.g:1444:3: (enumLiteral_25= 'DataDestruction' )
                    {
                    // InternalDasl.g:1444:3: (enumLiteral_25= 'DataDestruction' )
                    // InternalDasl.g:1445:4: enumLiteral_25= 'DataDestruction'
                    {
                    enumLiteral_25=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getDataDestructionEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getControlTypeAccess().getDataDestructionEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDasl.g:1452:3: (enumLiteral_26= 'FraudSecurity' )
                    {
                    // InternalDasl.g:1452:3: (enumLiteral_26= 'FraudSecurity' )
                    // InternalDasl.g:1453:4: enumLiteral_26= 'FraudSecurity'
                    {
                    enumLiteral_26=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getFraudSecurityEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getControlTypeAccess().getFraudSecurityEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDasl.g:1460:3: (enumLiteral_27= 'DataTransactionSecurity' )
                    {
                    // InternalDasl.g:1460:3: (enumLiteral_27= 'DataTransactionSecurity' )
                    // InternalDasl.g:1461:4: enumLiteral_27= 'DataTransactionSecurity'
                    {
                    enumLiteral_27=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getDataTransactionSecurityEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getControlTypeAccess().getDataTransactionSecurityEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDasl.g:1468:3: (enumLiteral_28= 'CentralisedHSM_CA_PKI' )
                    {
                    // InternalDasl.g:1468:3: (enumLiteral_28= 'CentralisedHSM_CA_PKI' )
                    // InternalDasl.g:1469:4: enumLiteral_28= 'CentralisedHSM_CA_PKI'
                    {
                    enumLiteral_28=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getCentralisedHSM_CA_PKIEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getControlTypeAccess().getCentralisedHSM_CA_PKIEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDasl.g:1476:3: (enumLiteral_29= 'Standalone' )
                    {
                    // InternalDasl.g:1476:3: (enumLiteral_29= 'Standalone' )
                    // InternalDasl.g:1477:4: enumLiteral_29= 'Standalone'
                    {
                    enumLiteral_29=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getStandaloneEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getControlTypeAccess().getStandaloneEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDasl.g:1484:3: (enumLiteral_30= 'SecurityTesting' )
                    {
                    // InternalDasl.g:1484:3: (enumLiteral_30= 'SecurityTesting' )
                    // InternalDasl.g:1485:4: enumLiteral_30= 'SecurityTesting'
                    {
                    enumLiteral_30=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getSecurityTestingEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getControlTypeAccess().getSecurityTestingEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDasl.g:1492:3: (enumLiteral_31= 'PatchManagement' )
                    {
                    // InternalDasl.g:1492:3: (enumLiteral_31= 'PatchManagement' )
                    // InternalDasl.g:1493:4: enumLiteral_31= 'PatchManagement'
                    {
                    enumLiteral_31=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getPatchManagementEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getControlTypeAccess().getPatchManagementEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDasl.g:1500:3: (enumLiteral_32= 'VulnerabilityManagement' )
                    {
                    // InternalDasl.g:1500:3: (enumLiteral_32= 'VulnerabilityManagement' )
                    // InternalDasl.g:1501:4: enumLiteral_32= 'VulnerabilityManagement'
                    {
                    enumLiteral_32=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getVulnerabilityManagementEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getControlTypeAccess().getVulnerabilityManagementEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDasl.g:1508:3: (enumLiteral_33= 'CentralisedReporting' )
                    {
                    // InternalDasl.g:1508:3: (enumLiteral_33= 'CentralisedReporting' )
                    // InternalDasl.g:1509:4: enumLiteral_33= 'CentralisedReporting'
                    {
                    enumLiteral_33=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getCentralisedReportingEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getControlTypeAccess().getCentralisedReportingEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDasl.g:1516:3: (enumLiteral_34= 'EventCorrelation' )
                    {
                    // InternalDasl.g:1516:3: (enumLiteral_34= 'EventCorrelation' )
                    // InternalDasl.g:1517:4: enumLiteral_34= 'EventCorrelation'
                    {
                    enumLiteral_34=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getEventCorrelationEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getControlTypeAccess().getEventCorrelationEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDasl.g:1524:3: (enumLiteral_35= 'SecurityAuditLogMonitoring' )
                    {
                    // InternalDasl.g:1524:3: (enumLiteral_35= 'SecurityAuditLogMonitoring' )
                    // InternalDasl.g:1525:4: enumLiteral_35= 'SecurityAuditLogMonitoring'
                    {
                    enumLiteral_35=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getSecurityAuditLogMonitoringEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getControlTypeAccess().getSecurityAuditLogMonitoringEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDasl.g:1532:3: (enumLiteral_36= 'ComplianceTesting' )
                    {
                    // InternalDasl.g:1532:3: (enumLiteral_36= 'ComplianceTesting' )
                    // InternalDasl.g:1533:4: enumLiteral_36= 'ComplianceTesting'
                    {
                    enumLiteral_36=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getComplianceTestingEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getControlTypeAccess().getComplianceTestingEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalDasl.g:1540:3: (enumLiteral_37= 'IncidentManagement' )
                    {
                    // InternalDasl.g:1540:3: (enumLiteral_37= 'IncidentManagement' )
                    // InternalDasl.g:1541:4: enumLiteral_37= 'IncidentManagement'
                    {
                    enumLiteral_37=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getIncidentManagementEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getControlTypeAccess().getIncidentManagementEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalDasl.g:1548:3: (enumLiteral_38= 'Forensic' )
                    {
                    // InternalDasl.g:1548:3: (enumLiteral_38= 'Forensic' )
                    // InternalDasl.g:1549:4: enumLiteral_38= 'Forensic'
                    {
                    enumLiteral_38=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getForensicEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getControlTypeAccess().getForensicEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalDasl.g:1556:3: (enumLiteral_39= 'Legal' )
                    {
                    // InternalDasl.g:1556:3: (enumLiteral_39= 'Legal' )
                    // InternalDasl.g:1557:4: enumLiteral_39= 'Legal'
                    {
                    enumLiteral_39=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getControlTypeAccess().getLegalEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getControlTypeAccess().getLegalEnumLiteralDeclaration_39());
                    			

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
    // $ANTLR end "ruleControlType"


    // $ANTLR start "ruleConfidentialityType"
    // InternalDasl.g:1567:1: ruleConfidentialityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) ) ;
    public final Enumerator ruleConfidentialityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDasl.g:1573:2: ( ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) ) )
            // InternalDasl.g:1574:2: ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) )
            {
            // InternalDasl.g:1574:2: ( (enumLiteral_0= 'Public' ) | (enumLiteral_1= 'Internal' ) | (enumLiteral_2= 'Confidential' ) | (enumLiteral_3= 'Restricted' ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt24=1;
                }
                break;
            case 86:
                {
                alt24=2;
                }
                break;
            case 87:
                {
                alt24=3;
                }
                break;
            case 88:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalDasl.g:1575:3: (enumLiteral_0= 'Public' )
                    {
                    // InternalDasl.g:1575:3: (enumLiteral_0= 'Public' )
                    // InternalDasl.g:1576:4: enumLiteral_0= 'Public'
                    {
                    enumLiteral_0=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1583:3: (enumLiteral_1= 'Internal' )
                    {
                    // InternalDasl.g:1583:3: (enumLiteral_1= 'Internal' )
                    // InternalDasl.g:1584:4: enumLiteral_1= 'Internal'
                    {
                    enumLiteral_1=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1591:3: (enumLiteral_2= 'Confidential' )
                    {
                    // InternalDasl.g:1591:3: (enumLiteral_2= 'Confidential' )
                    // InternalDasl.g:1592:4: enumLiteral_2= 'Confidential'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getConfidentialityTypeAccess().getConfidentialEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getConfidentialityTypeAccess().getConfidentialEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1599:3: (enumLiteral_3= 'Restricted' )
                    {
                    // InternalDasl.g:1599:3: (enumLiteral_3= 'Restricted' )
                    // InternalDasl.g:1600:4: enumLiteral_3= 'Restricted'
                    {
                    enumLiteral_3=(Token)match(input,88,FOLLOW_2); 

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
    // InternalDasl.g:1610:1: ruleIntegrityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) ) ;
    public final Enumerator ruleIntegrityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalDasl.g:1616:2: ( ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) ) )
            // InternalDasl.g:1617:2: ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) )
            {
            // InternalDasl.g:1617:2: ( (enumLiteral_0= 'Accurate' ) | (enumLiteral_1= 'HighlyTrusted' ) | (enumLiteral_2= 'Trusted' ) | (enumLiteral_3= 'Uncontrolled' ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt25=1;
                }
                break;
            case 90:
                {
                alt25=2;
                }
                break;
            case 91:
                {
                alt25=3;
                }
                break;
            case 92:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalDasl.g:1618:3: (enumLiteral_0= 'Accurate' )
                    {
                    // InternalDasl.g:1618:3: (enumLiteral_0= 'Accurate' )
                    // InternalDasl.g:1619:4: enumLiteral_0= 'Accurate'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1626:3: (enumLiteral_1= 'HighlyTrusted' )
                    {
                    // InternalDasl.g:1626:3: (enumLiteral_1= 'HighlyTrusted' )
                    // InternalDasl.g:1627:4: enumLiteral_1= 'HighlyTrusted'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1634:3: (enumLiteral_2= 'Trusted' )
                    {
                    // InternalDasl.g:1634:3: (enumLiteral_2= 'Trusted' )
                    // InternalDasl.g:1635:4: enumLiteral_2= 'Trusted'
                    {
                    enumLiteral_2=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1642:3: (enumLiteral_3= 'Uncontrolled' )
                    {
                    // InternalDasl.g:1642:3: (enumLiteral_3= 'Uncontrolled' )
                    // InternalDasl.g:1643:4: enumLiteral_3= 'Uncontrolled'
                    {
                    enumLiteral_3=(Token)match(input,92,FOLLOW_2); 

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
    // InternalDasl.g:1653:1: ruleAvailabilityType returns [Enumerator current=null] : ( (enumLiteral_0= 'Platinum' ) | (enumLiteral_1= 'Gold' ) | (enumLiteral_2= 'Silver' ) | (enumLiteral_3= 'Bronze' ) | (enumLiteral_4= 'Plastic' ) ) ;
    public final Enumerator ruleAvailabilityType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalDasl.g:1659:2: ( ( (enumLiteral_0= 'Platinum' ) | (enumLiteral_1= 'Gold' ) | (enumLiteral_2= 'Silver' ) | (enumLiteral_3= 'Bronze' ) | (enumLiteral_4= 'Plastic' ) ) )
            // InternalDasl.g:1660:2: ( (enumLiteral_0= 'Platinum' ) | (enumLiteral_1= 'Gold' ) | (enumLiteral_2= 'Silver' ) | (enumLiteral_3= 'Bronze' ) | (enumLiteral_4= 'Plastic' ) )
            {
            // InternalDasl.g:1660:2: ( (enumLiteral_0= 'Platinum' ) | (enumLiteral_1= 'Gold' ) | (enumLiteral_2= 'Silver' ) | (enumLiteral_3= 'Bronze' ) | (enumLiteral_4= 'Plastic' ) )
            int alt26=5;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt26=1;
                }
                break;
            case 94:
                {
                alt26=2;
                }
                break;
            case 95:
                {
                alt26=3;
                }
                break;
            case 96:
                {
                alt26=4;
                }
                break;
            case 97:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalDasl.g:1661:3: (enumLiteral_0= 'Platinum' )
                    {
                    // InternalDasl.g:1661:3: (enumLiteral_0= 'Platinum' )
                    // InternalDasl.g:1662:4: enumLiteral_0= 'Platinum'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getPlatinumEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAvailabilityTypeAccess().getPlatinumEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:1669:3: (enumLiteral_1= 'Gold' )
                    {
                    // InternalDasl.g:1669:3: (enumLiteral_1= 'Gold' )
                    // InternalDasl.g:1670:4: enumLiteral_1= 'Gold'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getGoldEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAvailabilityTypeAccess().getGoldEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:1677:3: (enumLiteral_2= 'Silver' )
                    {
                    // InternalDasl.g:1677:3: (enumLiteral_2= 'Silver' )
                    // InternalDasl.g:1678:4: enumLiteral_2= 'Silver'
                    {
                    enumLiteral_2=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getSilverEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAvailabilityTypeAccess().getSilverEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:1685:3: (enumLiteral_3= 'Bronze' )
                    {
                    // InternalDasl.g:1685:3: (enumLiteral_3= 'Bronze' )
                    // InternalDasl.g:1686:4: enumLiteral_3= 'Bronze'
                    {
                    enumLiteral_3=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getAvailabilityTypeAccess().getBronzeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAvailabilityTypeAccess().getBronzeEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:1693:3: (enumLiteral_4= 'Plastic' )
                    {
                    // InternalDasl.g:1693:3: (enumLiteral_4= 'Plastic' )
                    // InternalDasl.g:1694:4: enumLiteral_4= 'Plastic'
                    {
                    enumLiteral_4=(Token)match(input,97,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000012208203002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000108180000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008180010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008100010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000001E00000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x000000001E000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x00000003E0000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100180000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xFFFFE00000000000L,0x00000000001FFFFFL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000020000000000L});

}