package org.sabsa.dasl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.sabsa.dasl.services.DaslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDaslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PHYSICAL'", "'VIRTUAL'", "'CONTAINER'", "'IdentityValidation'", "'UserProvisioning'", "'SystemUserProvisioning'", "'IdentityTransformation'", "'UserRegistries'", "'CredentialManagement'", "'Authentication'", "'Authorisation'", "'PrivilegeManagement'", "'ReducedSignOn'", "'Federation'", "'AccessEntitlementGovernance'", "'FirewallsNetwork'", "'FirewallsApplication'", "'DenialofService'", "'NetworkAdmissionControl'", "'RemoteAccessGateway'", "'IntrusionPreventionDetection'", "'Antivirus'", "'ContentFilter'", "'MessageSecurity'", "'TransportSecurity'", "'StoredDataSecurity'", "'DataLossPrevention'", "'DataObfuscation'", "'DataDestruction'", "'FraudSecurity'", "'DataTransactionSecurity'", "'CentralisedHSM_CA_PKI'", "'Standalone'", "'SecurityTesting'", "'PatchManagement'", "'VulnerabilityManagement'", "'CentralisedReporting'", "'EventCorrelation'", "'SecurityAuditLogMonitoring'", "'ComplianceTesting'", "'IncidentManagement'", "'Forensic'", "'Legal'", "'Public'", "'Internal'", "'Restricted'", "'Accurate'", "'HighlyTrusted'", "'Trusted'", "'Uncontrolled'", "'Platinum'", "'Gold'", "'Silver'", "'Bronze'", "'Plastic'", "'.'", "'import'", "'zone'", "'{'", "'trustLevel'", "'ingress'", "'egress'", "'nodes'", "'}'", "'controls'", "'node'", "'ref'", "'host'", "'os'", "'type'", "'components'", "'component'", "'stereotype'", "'desc'", "'version'", "'assets'", "'vendor'", "'informationasset'", "'confidentiality'", "'integrity'", "'availability'", "'flow'", "'from'", "'to'", "'informationassets'", "'control'", "'implementation'"
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

    	public void setGrammarAccess(DaslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleSecurityModel"
    // InternalDasl.g:53:1: entryRuleSecurityModel : ruleSecurityModel EOF ;
    public final void entryRuleSecurityModel() throws RecognitionException {
        try {
            // InternalDasl.g:54:1: ( ruleSecurityModel EOF )
            // InternalDasl.g:55:1: ruleSecurityModel EOF
            {
             before(grammarAccess.getSecurityModelRule()); 
            pushFollow(FOLLOW_1);
            ruleSecurityModel();

            state._fsp--;

             after(grammarAccess.getSecurityModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSecurityModel"


    // $ANTLR start "ruleSecurityModel"
    // InternalDasl.g:62:1: ruleSecurityModel : ( ( rule__SecurityModel__ElementsAssignment )* ) ;
    public final void ruleSecurityModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:66:2: ( ( ( rule__SecurityModel__ElementsAssignment )* ) )
            // InternalDasl.g:67:2: ( ( rule__SecurityModel__ElementsAssignment )* )
            {
            // InternalDasl.g:67:2: ( ( rule__SecurityModel__ElementsAssignment )* )
            // InternalDasl.g:68:3: ( rule__SecurityModel__ElementsAssignment )*
            {
             before(grammarAccess.getSecurityModelAccess().getElementsAssignment()); 
            // InternalDasl.g:69:3: ( rule__SecurityModel__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=67 && LA1_0<=68)||LA1_0==76||LA1_0==82||LA1_0==88||LA1_0==92||LA1_0==96) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDasl.g:69:4: rule__SecurityModel__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__SecurityModel__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getSecurityModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSecurityModel"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalDasl.g:78:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalDasl.g:79:1: ( ruleQualifiedName EOF )
            // InternalDasl.g:80:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalDasl.g:87:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:91:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalDasl.g:92:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalDasl.g:92:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalDasl.g:93:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalDasl.g:94:3: ( rule__QualifiedName__Group__0 )
            // InternalDasl.g:94:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleImport"
    // InternalDasl.g:103:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalDasl.g:104:1: ( ruleImport EOF )
            // InternalDasl.g:105:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDasl.g:112:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:116:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalDasl.g:117:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalDasl.g:117:2: ( ( rule__Import__Group__0 ) )
            // InternalDasl.g:118:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalDasl.g:119:3: ( rule__Import__Group__0 )
            // InternalDasl.g:119:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleZone"
    // InternalDasl.g:128:1: entryRuleZone : ruleZone EOF ;
    public final void entryRuleZone() throws RecognitionException {
        try {
            // InternalDasl.g:129:1: ( ruleZone EOF )
            // InternalDasl.g:130:1: ruleZone EOF
            {
             before(grammarAccess.getZoneRule()); 
            pushFollow(FOLLOW_1);
            ruleZone();

            state._fsp--;

             after(grammarAccess.getZoneRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleZone"


    // $ANTLR start "ruleZone"
    // InternalDasl.g:137:1: ruleZone : ( ( rule__Zone__Group__0 ) ) ;
    public final void ruleZone() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:141:2: ( ( ( rule__Zone__Group__0 ) ) )
            // InternalDasl.g:142:2: ( ( rule__Zone__Group__0 ) )
            {
            // InternalDasl.g:142:2: ( ( rule__Zone__Group__0 ) )
            // InternalDasl.g:143:3: ( rule__Zone__Group__0 )
            {
             before(grammarAccess.getZoneAccess().getGroup()); 
            // InternalDasl.g:144:3: ( rule__Zone__Group__0 )
            // InternalDasl.g:144:4: rule__Zone__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Zone__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getZoneAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleZone"


    // $ANTLR start "entryRuleNode"
    // InternalDasl.g:153:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalDasl.g:154:1: ( ruleNode EOF )
            // InternalDasl.g:155:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalDasl.g:162:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:166:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalDasl.g:167:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalDasl.g:167:2: ( ( rule__Node__Group__0 ) )
            // InternalDasl.g:168:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalDasl.g:169:3: ( rule__Node__Group__0 )
            // InternalDasl.g:169:4: rule__Node__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleComponent"
    // InternalDasl.g:178:1: entryRuleComponent : ruleComponent EOF ;
    public final void entryRuleComponent() throws RecognitionException {
        try {
            // InternalDasl.g:179:1: ( ruleComponent EOF )
            // InternalDasl.g:180:1: ruleComponent EOF
            {
             before(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            ruleComponent();

            state._fsp--;

             after(grammarAccess.getComponentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalDasl.g:187:1: ruleComponent : ( ( rule__Component__Group__0 ) ) ;
    public final void ruleComponent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:191:2: ( ( ( rule__Component__Group__0 ) ) )
            // InternalDasl.g:192:2: ( ( rule__Component__Group__0 ) )
            {
            // InternalDasl.g:192:2: ( ( rule__Component__Group__0 ) )
            // InternalDasl.g:193:3: ( rule__Component__Group__0 )
            {
             before(grammarAccess.getComponentAccess().getGroup()); 
            // InternalDasl.g:194:3: ( rule__Component__Group__0 )
            // InternalDasl.g:194:4: rule__Component__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleInformationAsset"
    // InternalDasl.g:203:1: entryRuleInformationAsset : ruleInformationAsset EOF ;
    public final void entryRuleInformationAsset() throws RecognitionException {
        try {
            // InternalDasl.g:204:1: ( ruleInformationAsset EOF )
            // InternalDasl.g:205:1: ruleInformationAsset EOF
            {
             before(grammarAccess.getInformationAssetRule()); 
            pushFollow(FOLLOW_1);
            ruleInformationAsset();

            state._fsp--;

             after(grammarAccess.getInformationAssetRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInformationAsset"


    // $ANTLR start "ruleInformationAsset"
    // InternalDasl.g:212:1: ruleInformationAsset : ( ( rule__InformationAsset__Group__0 ) ) ;
    public final void ruleInformationAsset() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:216:2: ( ( ( rule__InformationAsset__Group__0 ) ) )
            // InternalDasl.g:217:2: ( ( rule__InformationAsset__Group__0 ) )
            {
            // InternalDasl.g:217:2: ( ( rule__InformationAsset__Group__0 ) )
            // InternalDasl.g:218:3: ( rule__InformationAsset__Group__0 )
            {
             before(grammarAccess.getInformationAssetAccess().getGroup()); 
            // InternalDasl.g:219:3: ( rule__InformationAsset__Group__0 )
            // InternalDasl.g:219:4: rule__InformationAsset__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInformationAsset"


    // $ANTLR start "entryRuleFlow"
    // InternalDasl.g:228:1: entryRuleFlow : ruleFlow EOF ;
    public final void entryRuleFlow() throws RecognitionException {
        try {
            // InternalDasl.g:229:1: ( ruleFlow EOF )
            // InternalDasl.g:230:1: ruleFlow EOF
            {
             before(grammarAccess.getFlowRule()); 
            pushFollow(FOLLOW_1);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getFlowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFlow"


    // $ANTLR start "ruleFlow"
    // InternalDasl.g:237:1: ruleFlow : ( ( rule__Flow__Group__0 ) ) ;
    public final void ruleFlow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:241:2: ( ( ( rule__Flow__Group__0 ) ) )
            // InternalDasl.g:242:2: ( ( rule__Flow__Group__0 ) )
            {
            // InternalDasl.g:242:2: ( ( rule__Flow__Group__0 ) )
            // InternalDasl.g:243:3: ( rule__Flow__Group__0 )
            {
             before(grammarAccess.getFlowAccess().getGroup()); 
            // InternalDasl.g:244:3: ( rule__Flow__Group__0 )
            // InternalDasl.g:244:4: rule__Flow__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFlow"


    // $ANTLR start "entryRuleControl"
    // InternalDasl.g:253:1: entryRuleControl : ruleControl EOF ;
    public final void entryRuleControl() throws RecognitionException {
        try {
            // InternalDasl.g:254:1: ( ruleControl EOF )
            // InternalDasl.g:255:1: ruleControl EOF
            {
             before(grammarAccess.getControlRule()); 
            pushFollow(FOLLOW_1);
            ruleControl();

            state._fsp--;

             after(grammarAccess.getControlRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleControl"


    // $ANTLR start "ruleControl"
    // InternalDasl.g:262:1: ruleControl : ( ( rule__Control__Group__0 ) ) ;
    public final void ruleControl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:266:2: ( ( ( rule__Control__Group__0 ) ) )
            // InternalDasl.g:267:2: ( ( rule__Control__Group__0 ) )
            {
            // InternalDasl.g:267:2: ( ( rule__Control__Group__0 ) )
            // InternalDasl.g:268:3: ( rule__Control__Group__0 )
            {
             before(grammarAccess.getControlAccess().getGroup()); 
            // InternalDasl.g:269:3: ( rule__Control__Group__0 )
            // InternalDasl.g:269:4: rule__Control__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Control__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getControlAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleControl"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalDasl.g:278:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalDasl.g:279:1: ( ruleAbstractElement EOF )
            // InternalDasl.g:280:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalDasl.g:287:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:291:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalDasl.g:292:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalDasl.g:292:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalDasl.g:293:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalDasl.g:294:3: ( rule__AbstractElement__Alternatives )
            // InternalDasl.g:294:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "ruleNodeType"
    // InternalDasl.g:303:1: ruleNodeType : ( ( rule__NodeType__Alternatives ) ) ;
    public final void ruleNodeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:307:1: ( ( ( rule__NodeType__Alternatives ) ) )
            // InternalDasl.g:308:2: ( ( rule__NodeType__Alternatives ) )
            {
            // InternalDasl.g:308:2: ( ( rule__NodeType__Alternatives ) )
            // InternalDasl.g:309:3: ( rule__NodeType__Alternatives )
            {
             before(grammarAccess.getNodeTypeAccess().getAlternatives()); 
            // InternalDasl.g:310:3: ( rule__NodeType__Alternatives )
            // InternalDasl.g:310:4: rule__NodeType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NodeType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeType"


    // $ANTLR start "ruleControlType"
    // InternalDasl.g:319:1: ruleControlType : ( ( rule__ControlType__Alternatives ) ) ;
    public final void ruleControlType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:323:1: ( ( ( rule__ControlType__Alternatives ) ) )
            // InternalDasl.g:324:2: ( ( rule__ControlType__Alternatives ) )
            {
            // InternalDasl.g:324:2: ( ( rule__ControlType__Alternatives ) )
            // InternalDasl.g:325:3: ( rule__ControlType__Alternatives )
            {
             before(grammarAccess.getControlTypeAccess().getAlternatives()); 
            // InternalDasl.g:326:3: ( rule__ControlType__Alternatives )
            // InternalDasl.g:326:4: rule__ControlType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ControlType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getControlTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleControlType"


    // $ANTLR start "ruleConfidentialityType"
    // InternalDasl.g:335:1: ruleConfidentialityType : ( ( rule__ConfidentialityType__Alternatives ) ) ;
    public final void ruleConfidentialityType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:339:1: ( ( ( rule__ConfidentialityType__Alternatives ) ) )
            // InternalDasl.g:340:2: ( ( rule__ConfidentialityType__Alternatives ) )
            {
            // InternalDasl.g:340:2: ( ( rule__ConfidentialityType__Alternatives ) )
            // InternalDasl.g:341:3: ( rule__ConfidentialityType__Alternatives )
            {
             before(grammarAccess.getConfidentialityTypeAccess().getAlternatives()); 
            // InternalDasl.g:342:3: ( rule__ConfidentialityType__Alternatives )
            // InternalDasl.g:342:4: rule__ConfidentialityType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ConfidentialityType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConfidentialityTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfidentialityType"


    // $ANTLR start "ruleIntegrityType"
    // InternalDasl.g:351:1: ruleIntegrityType : ( ( rule__IntegrityType__Alternatives ) ) ;
    public final void ruleIntegrityType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:355:1: ( ( ( rule__IntegrityType__Alternatives ) ) )
            // InternalDasl.g:356:2: ( ( rule__IntegrityType__Alternatives ) )
            {
            // InternalDasl.g:356:2: ( ( rule__IntegrityType__Alternatives ) )
            // InternalDasl.g:357:3: ( rule__IntegrityType__Alternatives )
            {
             before(grammarAccess.getIntegrityTypeAccess().getAlternatives()); 
            // InternalDasl.g:358:3: ( rule__IntegrityType__Alternatives )
            // InternalDasl.g:358:4: rule__IntegrityType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IntegrityType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntegrityTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegrityType"


    // $ANTLR start "ruleAvailabilityType"
    // InternalDasl.g:367:1: ruleAvailabilityType : ( ( rule__AvailabilityType__Alternatives ) ) ;
    public final void ruleAvailabilityType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:371:1: ( ( ( rule__AvailabilityType__Alternatives ) ) )
            // InternalDasl.g:372:2: ( ( rule__AvailabilityType__Alternatives ) )
            {
            // InternalDasl.g:372:2: ( ( rule__AvailabilityType__Alternatives ) )
            // InternalDasl.g:373:3: ( rule__AvailabilityType__Alternatives )
            {
             before(grammarAccess.getAvailabilityTypeAccess().getAlternatives()); 
            // InternalDasl.g:374:3: ( rule__AvailabilityType__Alternatives )
            // InternalDasl.g:374:4: rule__AvailabilityType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AvailabilityType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAvailabilityTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAvailabilityType"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalDasl.g:382:1: rule__AbstractElement__Alternatives : ( ( ruleInformationAsset ) | ( ruleComponent ) | ( ruleZone ) | ( ruleNode ) | ( ruleControl ) | ( ruleFlow ) | ( ruleImport ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:386:1: ( ( ruleInformationAsset ) | ( ruleComponent ) | ( ruleZone ) | ( ruleNode ) | ( ruleControl ) | ( ruleFlow ) | ( ruleImport ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt2=1;
                }
                break;
            case 82:
                {
                alt2=2;
                }
                break;
            case 68:
                {
                alt2=3;
                }
                break;
            case 76:
                {
                alt2=4;
                }
                break;
            case 96:
                {
                alt2=5;
                }
                break;
            case 92:
                {
                alt2=6;
                }
                break;
            case 67:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDasl.g:387:2: ( ruleInformationAsset )
                    {
                    // InternalDasl.g:387:2: ( ruleInformationAsset )
                    // InternalDasl.g:388:3: ruleInformationAsset
                    {
                     before(grammarAccess.getAbstractElementAccess().getInformationAssetParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleInformationAsset();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getInformationAssetParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:393:2: ( ruleComponent )
                    {
                    // InternalDasl.g:393:2: ( ruleComponent )
                    // InternalDasl.g:394:3: ruleComponent
                    {
                     before(grammarAccess.getAbstractElementAccess().getComponentParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleComponent();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getComponentParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:399:2: ( ruleZone )
                    {
                    // InternalDasl.g:399:2: ( ruleZone )
                    // InternalDasl.g:400:3: ruleZone
                    {
                     before(grammarAccess.getAbstractElementAccess().getZoneParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleZone();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getZoneParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:405:2: ( ruleNode )
                    {
                    // InternalDasl.g:405:2: ( ruleNode )
                    // InternalDasl.g:406:3: ruleNode
                    {
                     before(grammarAccess.getAbstractElementAccess().getNodeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleNode();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getNodeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:411:2: ( ruleControl )
                    {
                    // InternalDasl.g:411:2: ( ruleControl )
                    // InternalDasl.g:412:3: ruleControl
                    {
                     before(grammarAccess.getAbstractElementAccess().getControlParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleControl();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getControlParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDasl.g:417:2: ( ruleFlow )
                    {
                    // InternalDasl.g:417:2: ( ruleFlow )
                    // InternalDasl.g:418:3: ruleFlow
                    {
                     before(grammarAccess.getAbstractElementAccess().getFlowParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleFlow();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getFlowParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDasl.g:423:2: ( ruleImport )
                    {
                    // InternalDasl.g:423:2: ( ruleImport )
                    // InternalDasl.g:424:3: ruleImport
                    {
                     before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__NodeType__Alternatives"
    // InternalDasl.g:433:1: rule__NodeType__Alternatives : ( ( ( 'PHYSICAL' ) ) | ( ( 'VIRTUAL' ) ) | ( ( 'CONTAINER' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:437:1: ( ( ( 'PHYSICAL' ) ) | ( ( 'VIRTUAL' ) ) | ( ( 'CONTAINER' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDasl.g:438:2: ( ( 'PHYSICAL' ) )
                    {
                    // InternalDasl.g:438:2: ( ( 'PHYSICAL' ) )
                    // InternalDasl.g:439:3: ( 'PHYSICAL' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0()); 
                    // InternalDasl.g:440:3: ( 'PHYSICAL' )
                    // InternalDasl.g:440:4: 'PHYSICAL'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getPHYSICALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:444:2: ( ( 'VIRTUAL' ) )
                    {
                    // InternalDasl.g:444:2: ( ( 'VIRTUAL' ) )
                    // InternalDasl.g:445:3: ( 'VIRTUAL' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1()); 
                    // InternalDasl.g:446:3: ( 'VIRTUAL' )
                    // InternalDasl.g:446:4: 'VIRTUAL'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getVIRTUALEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:450:2: ( ( 'CONTAINER' ) )
                    {
                    // InternalDasl.g:450:2: ( ( 'CONTAINER' ) )
                    // InternalDasl.g:451:3: ( 'CONTAINER' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getCONTAINEREnumLiteralDeclaration_2()); 
                    // InternalDasl.g:452:3: ( 'CONTAINER' )
                    // InternalDasl.g:452:4: 'CONTAINER'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getCONTAINEREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeType__Alternatives"


    // $ANTLR start "rule__ControlType__Alternatives"
    // InternalDasl.g:460:1: rule__ControlType__Alternatives : ( ( ( 'IdentityValidation' ) ) | ( ( 'UserProvisioning' ) ) | ( ( 'SystemUserProvisioning' ) ) | ( ( 'IdentityTransformation' ) ) | ( ( 'UserRegistries' ) ) | ( ( 'CredentialManagement' ) ) | ( ( 'Authentication' ) ) | ( ( 'Authorisation' ) ) | ( ( 'PrivilegeManagement' ) ) | ( ( 'ReducedSignOn' ) ) | ( ( 'Federation' ) ) | ( ( 'AccessEntitlementGovernance' ) ) | ( ( 'FirewallsNetwork' ) ) | ( ( 'FirewallsApplication' ) ) | ( ( 'DenialofService' ) ) | ( ( 'NetworkAdmissionControl' ) ) | ( ( 'RemoteAccessGateway' ) ) | ( ( 'IntrusionPreventionDetection' ) ) | ( ( 'Antivirus' ) ) | ( ( 'ContentFilter' ) ) | ( ( 'MessageSecurity' ) ) | ( ( 'TransportSecurity' ) ) | ( ( 'StoredDataSecurity' ) ) | ( ( 'DataLossPrevention' ) ) | ( ( 'DataObfuscation' ) ) | ( ( 'DataDestruction' ) ) | ( ( 'FraudSecurity' ) ) | ( ( 'DataTransactionSecurity' ) ) | ( ( 'CentralisedHSM_CA_PKI' ) ) | ( ( 'Standalone' ) ) | ( ( 'SecurityTesting' ) ) | ( ( 'PatchManagement' ) ) | ( ( 'VulnerabilityManagement' ) ) | ( ( 'CentralisedReporting' ) ) | ( ( 'EventCorrelation' ) ) | ( ( 'SecurityAuditLogMonitoring' ) ) | ( ( 'ComplianceTesting' ) ) | ( ( 'IncidentManagement' ) ) | ( ( 'Forensic' ) ) | ( ( 'Legal' ) ) );
    public final void rule__ControlType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:464:1: ( ( ( 'IdentityValidation' ) ) | ( ( 'UserProvisioning' ) ) | ( ( 'SystemUserProvisioning' ) ) | ( ( 'IdentityTransformation' ) ) | ( ( 'UserRegistries' ) ) | ( ( 'CredentialManagement' ) ) | ( ( 'Authentication' ) ) | ( ( 'Authorisation' ) ) | ( ( 'PrivilegeManagement' ) ) | ( ( 'ReducedSignOn' ) ) | ( ( 'Federation' ) ) | ( ( 'AccessEntitlementGovernance' ) ) | ( ( 'FirewallsNetwork' ) ) | ( ( 'FirewallsApplication' ) ) | ( ( 'DenialofService' ) ) | ( ( 'NetworkAdmissionControl' ) ) | ( ( 'RemoteAccessGateway' ) ) | ( ( 'IntrusionPreventionDetection' ) ) | ( ( 'Antivirus' ) ) | ( ( 'ContentFilter' ) ) | ( ( 'MessageSecurity' ) ) | ( ( 'TransportSecurity' ) ) | ( ( 'StoredDataSecurity' ) ) | ( ( 'DataLossPrevention' ) ) | ( ( 'DataObfuscation' ) ) | ( ( 'DataDestruction' ) ) | ( ( 'FraudSecurity' ) ) | ( ( 'DataTransactionSecurity' ) ) | ( ( 'CentralisedHSM_CA_PKI' ) ) | ( ( 'Standalone' ) ) | ( ( 'SecurityTesting' ) ) | ( ( 'PatchManagement' ) ) | ( ( 'VulnerabilityManagement' ) ) | ( ( 'CentralisedReporting' ) ) | ( ( 'EventCorrelation' ) ) | ( ( 'SecurityAuditLogMonitoring' ) ) | ( ( 'ComplianceTesting' ) ) | ( ( 'IncidentManagement' ) ) | ( ( 'Forensic' ) ) | ( ( 'Legal' ) ) )
            int alt4=40;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 17:
                {
                alt4=4;
                }
                break;
            case 18:
                {
                alt4=5;
                }
                break;
            case 19:
                {
                alt4=6;
                }
                break;
            case 20:
                {
                alt4=7;
                }
                break;
            case 21:
                {
                alt4=8;
                }
                break;
            case 22:
                {
                alt4=9;
                }
                break;
            case 23:
                {
                alt4=10;
                }
                break;
            case 24:
                {
                alt4=11;
                }
                break;
            case 25:
                {
                alt4=12;
                }
                break;
            case 26:
                {
                alt4=13;
                }
                break;
            case 27:
                {
                alt4=14;
                }
                break;
            case 28:
                {
                alt4=15;
                }
                break;
            case 29:
                {
                alt4=16;
                }
                break;
            case 30:
                {
                alt4=17;
                }
                break;
            case 31:
                {
                alt4=18;
                }
                break;
            case 32:
                {
                alt4=19;
                }
                break;
            case 33:
                {
                alt4=20;
                }
                break;
            case 34:
                {
                alt4=21;
                }
                break;
            case 35:
                {
                alt4=22;
                }
                break;
            case 36:
                {
                alt4=23;
                }
                break;
            case 37:
                {
                alt4=24;
                }
                break;
            case 38:
                {
                alt4=25;
                }
                break;
            case 39:
                {
                alt4=26;
                }
                break;
            case 40:
                {
                alt4=27;
                }
                break;
            case 41:
                {
                alt4=28;
                }
                break;
            case 42:
                {
                alt4=29;
                }
                break;
            case 43:
                {
                alt4=30;
                }
                break;
            case 44:
                {
                alt4=31;
                }
                break;
            case 45:
                {
                alt4=32;
                }
                break;
            case 46:
                {
                alt4=33;
                }
                break;
            case 47:
                {
                alt4=34;
                }
                break;
            case 48:
                {
                alt4=35;
                }
                break;
            case 49:
                {
                alt4=36;
                }
                break;
            case 50:
                {
                alt4=37;
                }
                break;
            case 51:
                {
                alt4=38;
                }
                break;
            case 52:
                {
                alt4=39;
                }
                break;
            case 53:
                {
                alt4=40;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDasl.g:465:2: ( ( 'IdentityValidation' ) )
                    {
                    // InternalDasl.g:465:2: ( ( 'IdentityValidation' ) )
                    // InternalDasl.g:466:3: ( 'IdentityValidation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getIdentityValidationEnumLiteralDeclaration_0()); 
                    // InternalDasl.g:467:3: ( 'IdentityValidation' )
                    // InternalDasl.g:467:4: 'IdentityValidation'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getIdentityValidationEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:471:2: ( ( 'UserProvisioning' ) )
                    {
                    // InternalDasl.g:471:2: ( ( 'UserProvisioning' ) )
                    // InternalDasl.g:472:3: ( 'UserProvisioning' )
                    {
                     before(grammarAccess.getControlTypeAccess().getUserProvisioningEnumLiteralDeclaration_1()); 
                    // InternalDasl.g:473:3: ( 'UserProvisioning' )
                    // InternalDasl.g:473:4: 'UserProvisioning'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getUserProvisioningEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:477:2: ( ( 'SystemUserProvisioning' ) )
                    {
                    // InternalDasl.g:477:2: ( ( 'SystemUserProvisioning' ) )
                    // InternalDasl.g:478:3: ( 'SystemUserProvisioning' )
                    {
                     before(grammarAccess.getControlTypeAccess().getSystemUserProvisioningEnumLiteralDeclaration_2()); 
                    // InternalDasl.g:479:3: ( 'SystemUserProvisioning' )
                    // InternalDasl.g:479:4: 'SystemUserProvisioning'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getSystemUserProvisioningEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:483:2: ( ( 'IdentityTransformation' ) )
                    {
                    // InternalDasl.g:483:2: ( ( 'IdentityTransformation' ) )
                    // InternalDasl.g:484:3: ( 'IdentityTransformation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getIdentityTransformationEnumLiteralDeclaration_3()); 
                    // InternalDasl.g:485:3: ( 'IdentityTransformation' )
                    // InternalDasl.g:485:4: 'IdentityTransformation'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getIdentityTransformationEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:489:2: ( ( 'UserRegistries' ) )
                    {
                    // InternalDasl.g:489:2: ( ( 'UserRegistries' ) )
                    // InternalDasl.g:490:3: ( 'UserRegistries' )
                    {
                     before(grammarAccess.getControlTypeAccess().getUserRegistriesEnumLiteralDeclaration_4()); 
                    // InternalDasl.g:491:3: ( 'UserRegistries' )
                    // InternalDasl.g:491:4: 'UserRegistries'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getUserRegistriesEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDasl.g:495:2: ( ( 'CredentialManagement' ) )
                    {
                    // InternalDasl.g:495:2: ( ( 'CredentialManagement' ) )
                    // InternalDasl.g:496:3: ( 'CredentialManagement' )
                    {
                     before(grammarAccess.getControlTypeAccess().getCredentialManagementEnumLiteralDeclaration_5()); 
                    // InternalDasl.g:497:3: ( 'CredentialManagement' )
                    // InternalDasl.g:497:4: 'CredentialManagement'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getCredentialManagementEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDasl.g:501:2: ( ( 'Authentication' ) )
                    {
                    // InternalDasl.g:501:2: ( ( 'Authentication' ) )
                    // InternalDasl.g:502:3: ( 'Authentication' )
                    {
                     before(grammarAccess.getControlTypeAccess().getAuthenticationEnumLiteralDeclaration_6()); 
                    // InternalDasl.g:503:3: ( 'Authentication' )
                    // InternalDasl.g:503:4: 'Authentication'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getAuthenticationEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDasl.g:507:2: ( ( 'Authorisation' ) )
                    {
                    // InternalDasl.g:507:2: ( ( 'Authorisation' ) )
                    // InternalDasl.g:508:3: ( 'Authorisation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getAuthorisationEnumLiteralDeclaration_7()); 
                    // InternalDasl.g:509:3: ( 'Authorisation' )
                    // InternalDasl.g:509:4: 'Authorisation'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getAuthorisationEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDasl.g:513:2: ( ( 'PrivilegeManagement' ) )
                    {
                    // InternalDasl.g:513:2: ( ( 'PrivilegeManagement' ) )
                    // InternalDasl.g:514:3: ( 'PrivilegeManagement' )
                    {
                     before(grammarAccess.getControlTypeAccess().getPrivilegeManagementEnumLiteralDeclaration_8()); 
                    // InternalDasl.g:515:3: ( 'PrivilegeManagement' )
                    // InternalDasl.g:515:4: 'PrivilegeManagement'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getPrivilegeManagementEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDasl.g:519:2: ( ( 'ReducedSignOn' ) )
                    {
                    // InternalDasl.g:519:2: ( ( 'ReducedSignOn' ) )
                    // InternalDasl.g:520:3: ( 'ReducedSignOn' )
                    {
                     before(grammarAccess.getControlTypeAccess().getReducedSignOnEnumLiteralDeclaration_9()); 
                    // InternalDasl.g:521:3: ( 'ReducedSignOn' )
                    // InternalDasl.g:521:4: 'ReducedSignOn'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getReducedSignOnEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDasl.g:525:2: ( ( 'Federation' ) )
                    {
                    // InternalDasl.g:525:2: ( ( 'Federation' ) )
                    // InternalDasl.g:526:3: ( 'Federation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getFederationEnumLiteralDeclaration_10()); 
                    // InternalDasl.g:527:3: ( 'Federation' )
                    // InternalDasl.g:527:4: 'Federation'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getFederationEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDasl.g:531:2: ( ( 'AccessEntitlementGovernance' ) )
                    {
                    // InternalDasl.g:531:2: ( ( 'AccessEntitlementGovernance' ) )
                    // InternalDasl.g:532:3: ( 'AccessEntitlementGovernance' )
                    {
                     before(grammarAccess.getControlTypeAccess().getAccessEntitlementGovernanceEnumLiteralDeclaration_11()); 
                    // InternalDasl.g:533:3: ( 'AccessEntitlementGovernance' )
                    // InternalDasl.g:533:4: 'AccessEntitlementGovernance'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getAccessEntitlementGovernanceEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDasl.g:537:2: ( ( 'FirewallsNetwork' ) )
                    {
                    // InternalDasl.g:537:2: ( ( 'FirewallsNetwork' ) )
                    // InternalDasl.g:538:3: ( 'FirewallsNetwork' )
                    {
                     before(grammarAccess.getControlTypeAccess().getFirewallsNetworkEnumLiteralDeclaration_12()); 
                    // InternalDasl.g:539:3: ( 'FirewallsNetwork' )
                    // InternalDasl.g:539:4: 'FirewallsNetwork'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getFirewallsNetworkEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDasl.g:543:2: ( ( 'FirewallsApplication' ) )
                    {
                    // InternalDasl.g:543:2: ( ( 'FirewallsApplication' ) )
                    // InternalDasl.g:544:3: ( 'FirewallsApplication' )
                    {
                     before(grammarAccess.getControlTypeAccess().getFirewallsApplicationEnumLiteralDeclaration_13()); 
                    // InternalDasl.g:545:3: ( 'FirewallsApplication' )
                    // InternalDasl.g:545:4: 'FirewallsApplication'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getFirewallsApplicationEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDasl.g:549:2: ( ( 'DenialofService' ) )
                    {
                    // InternalDasl.g:549:2: ( ( 'DenialofService' ) )
                    // InternalDasl.g:550:3: ( 'DenialofService' )
                    {
                     before(grammarAccess.getControlTypeAccess().getDenialofServiceEnumLiteralDeclaration_14()); 
                    // InternalDasl.g:551:3: ( 'DenialofService' )
                    // InternalDasl.g:551:4: 'DenialofService'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getDenialofServiceEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDasl.g:555:2: ( ( 'NetworkAdmissionControl' ) )
                    {
                    // InternalDasl.g:555:2: ( ( 'NetworkAdmissionControl' ) )
                    // InternalDasl.g:556:3: ( 'NetworkAdmissionControl' )
                    {
                     before(grammarAccess.getControlTypeAccess().getNetworkAdmissionControlEnumLiteralDeclaration_15()); 
                    // InternalDasl.g:557:3: ( 'NetworkAdmissionControl' )
                    // InternalDasl.g:557:4: 'NetworkAdmissionControl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getNetworkAdmissionControlEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDasl.g:561:2: ( ( 'RemoteAccessGateway' ) )
                    {
                    // InternalDasl.g:561:2: ( ( 'RemoteAccessGateway' ) )
                    // InternalDasl.g:562:3: ( 'RemoteAccessGateway' )
                    {
                     before(grammarAccess.getControlTypeAccess().getRemoteAccessGatewayEnumLiteralDeclaration_16()); 
                    // InternalDasl.g:563:3: ( 'RemoteAccessGateway' )
                    // InternalDasl.g:563:4: 'RemoteAccessGateway'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getRemoteAccessGatewayEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDasl.g:567:2: ( ( 'IntrusionPreventionDetection' ) )
                    {
                    // InternalDasl.g:567:2: ( ( 'IntrusionPreventionDetection' ) )
                    // InternalDasl.g:568:3: ( 'IntrusionPreventionDetection' )
                    {
                     before(grammarAccess.getControlTypeAccess().getIntrusionPreventionDetectionEnumLiteralDeclaration_17()); 
                    // InternalDasl.g:569:3: ( 'IntrusionPreventionDetection' )
                    // InternalDasl.g:569:4: 'IntrusionPreventionDetection'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getIntrusionPreventionDetectionEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDasl.g:573:2: ( ( 'Antivirus' ) )
                    {
                    // InternalDasl.g:573:2: ( ( 'Antivirus' ) )
                    // InternalDasl.g:574:3: ( 'Antivirus' )
                    {
                     before(grammarAccess.getControlTypeAccess().getAntivirusEnumLiteralDeclaration_18()); 
                    // InternalDasl.g:575:3: ( 'Antivirus' )
                    // InternalDasl.g:575:4: 'Antivirus'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getAntivirusEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDasl.g:579:2: ( ( 'ContentFilter' ) )
                    {
                    // InternalDasl.g:579:2: ( ( 'ContentFilter' ) )
                    // InternalDasl.g:580:3: ( 'ContentFilter' )
                    {
                     before(grammarAccess.getControlTypeAccess().getContentFilterEnumLiteralDeclaration_19()); 
                    // InternalDasl.g:581:3: ( 'ContentFilter' )
                    // InternalDasl.g:581:4: 'ContentFilter'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getContentFilterEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDasl.g:585:2: ( ( 'MessageSecurity' ) )
                    {
                    // InternalDasl.g:585:2: ( ( 'MessageSecurity' ) )
                    // InternalDasl.g:586:3: ( 'MessageSecurity' )
                    {
                     before(grammarAccess.getControlTypeAccess().getMessageSecurityEnumLiteralDeclaration_20()); 
                    // InternalDasl.g:587:3: ( 'MessageSecurity' )
                    // InternalDasl.g:587:4: 'MessageSecurity'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getMessageSecurityEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDasl.g:591:2: ( ( 'TransportSecurity' ) )
                    {
                    // InternalDasl.g:591:2: ( ( 'TransportSecurity' ) )
                    // InternalDasl.g:592:3: ( 'TransportSecurity' )
                    {
                     before(grammarAccess.getControlTypeAccess().getTransportSecurityEnumLiteralDeclaration_21()); 
                    // InternalDasl.g:593:3: ( 'TransportSecurity' )
                    // InternalDasl.g:593:4: 'TransportSecurity'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getTransportSecurityEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDasl.g:597:2: ( ( 'StoredDataSecurity' ) )
                    {
                    // InternalDasl.g:597:2: ( ( 'StoredDataSecurity' ) )
                    // InternalDasl.g:598:3: ( 'StoredDataSecurity' )
                    {
                     before(grammarAccess.getControlTypeAccess().getStoredDataSecurityEnumLiteralDeclaration_22()); 
                    // InternalDasl.g:599:3: ( 'StoredDataSecurity' )
                    // InternalDasl.g:599:4: 'StoredDataSecurity'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getStoredDataSecurityEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDasl.g:603:2: ( ( 'DataLossPrevention' ) )
                    {
                    // InternalDasl.g:603:2: ( ( 'DataLossPrevention' ) )
                    // InternalDasl.g:604:3: ( 'DataLossPrevention' )
                    {
                     before(grammarAccess.getControlTypeAccess().getDataLossPreventionEnumLiteralDeclaration_23()); 
                    // InternalDasl.g:605:3: ( 'DataLossPrevention' )
                    // InternalDasl.g:605:4: 'DataLossPrevention'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getDataLossPreventionEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDasl.g:609:2: ( ( 'DataObfuscation' ) )
                    {
                    // InternalDasl.g:609:2: ( ( 'DataObfuscation' ) )
                    // InternalDasl.g:610:3: ( 'DataObfuscation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getDataObfuscationEnumLiteralDeclaration_24()); 
                    // InternalDasl.g:611:3: ( 'DataObfuscation' )
                    // InternalDasl.g:611:4: 'DataObfuscation'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getDataObfuscationEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDasl.g:615:2: ( ( 'DataDestruction' ) )
                    {
                    // InternalDasl.g:615:2: ( ( 'DataDestruction' ) )
                    // InternalDasl.g:616:3: ( 'DataDestruction' )
                    {
                     before(grammarAccess.getControlTypeAccess().getDataDestructionEnumLiteralDeclaration_25()); 
                    // InternalDasl.g:617:3: ( 'DataDestruction' )
                    // InternalDasl.g:617:4: 'DataDestruction'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getDataDestructionEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDasl.g:621:2: ( ( 'FraudSecurity' ) )
                    {
                    // InternalDasl.g:621:2: ( ( 'FraudSecurity' ) )
                    // InternalDasl.g:622:3: ( 'FraudSecurity' )
                    {
                     before(grammarAccess.getControlTypeAccess().getFraudSecurityEnumLiteralDeclaration_26()); 
                    // InternalDasl.g:623:3: ( 'FraudSecurity' )
                    // InternalDasl.g:623:4: 'FraudSecurity'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getFraudSecurityEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDasl.g:627:2: ( ( 'DataTransactionSecurity' ) )
                    {
                    // InternalDasl.g:627:2: ( ( 'DataTransactionSecurity' ) )
                    // InternalDasl.g:628:3: ( 'DataTransactionSecurity' )
                    {
                     before(grammarAccess.getControlTypeAccess().getDataTransactionSecurityEnumLiteralDeclaration_27()); 
                    // InternalDasl.g:629:3: ( 'DataTransactionSecurity' )
                    // InternalDasl.g:629:4: 'DataTransactionSecurity'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getDataTransactionSecurityEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDasl.g:633:2: ( ( 'CentralisedHSM_CA_PKI' ) )
                    {
                    // InternalDasl.g:633:2: ( ( 'CentralisedHSM_CA_PKI' ) )
                    // InternalDasl.g:634:3: ( 'CentralisedHSM_CA_PKI' )
                    {
                     before(grammarAccess.getControlTypeAccess().getCentralisedHSM_CA_PKIEnumLiteralDeclaration_28()); 
                    // InternalDasl.g:635:3: ( 'CentralisedHSM_CA_PKI' )
                    // InternalDasl.g:635:4: 'CentralisedHSM_CA_PKI'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getCentralisedHSM_CA_PKIEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDasl.g:639:2: ( ( 'Standalone' ) )
                    {
                    // InternalDasl.g:639:2: ( ( 'Standalone' ) )
                    // InternalDasl.g:640:3: ( 'Standalone' )
                    {
                     before(grammarAccess.getControlTypeAccess().getStandaloneEnumLiteralDeclaration_29()); 
                    // InternalDasl.g:641:3: ( 'Standalone' )
                    // InternalDasl.g:641:4: 'Standalone'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getStandaloneEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDasl.g:645:2: ( ( 'SecurityTesting' ) )
                    {
                    // InternalDasl.g:645:2: ( ( 'SecurityTesting' ) )
                    // InternalDasl.g:646:3: ( 'SecurityTesting' )
                    {
                     before(grammarAccess.getControlTypeAccess().getSecurityTestingEnumLiteralDeclaration_30()); 
                    // InternalDasl.g:647:3: ( 'SecurityTesting' )
                    // InternalDasl.g:647:4: 'SecurityTesting'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getSecurityTestingEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDasl.g:651:2: ( ( 'PatchManagement' ) )
                    {
                    // InternalDasl.g:651:2: ( ( 'PatchManagement' ) )
                    // InternalDasl.g:652:3: ( 'PatchManagement' )
                    {
                     before(grammarAccess.getControlTypeAccess().getPatchManagementEnumLiteralDeclaration_31()); 
                    // InternalDasl.g:653:3: ( 'PatchManagement' )
                    // InternalDasl.g:653:4: 'PatchManagement'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getPatchManagementEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDasl.g:657:2: ( ( 'VulnerabilityManagement' ) )
                    {
                    // InternalDasl.g:657:2: ( ( 'VulnerabilityManagement' ) )
                    // InternalDasl.g:658:3: ( 'VulnerabilityManagement' )
                    {
                     before(grammarAccess.getControlTypeAccess().getVulnerabilityManagementEnumLiteralDeclaration_32()); 
                    // InternalDasl.g:659:3: ( 'VulnerabilityManagement' )
                    // InternalDasl.g:659:4: 'VulnerabilityManagement'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getVulnerabilityManagementEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDasl.g:663:2: ( ( 'CentralisedReporting' ) )
                    {
                    // InternalDasl.g:663:2: ( ( 'CentralisedReporting' ) )
                    // InternalDasl.g:664:3: ( 'CentralisedReporting' )
                    {
                     before(grammarAccess.getControlTypeAccess().getCentralisedReportingEnumLiteralDeclaration_33()); 
                    // InternalDasl.g:665:3: ( 'CentralisedReporting' )
                    // InternalDasl.g:665:4: 'CentralisedReporting'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getCentralisedReportingEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDasl.g:669:2: ( ( 'EventCorrelation' ) )
                    {
                    // InternalDasl.g:669:2: ( ( 'EventCorrelation' ) )
                    // InternalDasl.g:670:3: ( 'EventCorrelation' )
                    {
                     before(grammarAccess.getControlTypeAccess().getEventCorrelationEnumLiteralDeclaration_34()); 
                    // InternalDasl.g:671:3: ( 'EventCorrelation' )
                    // InternalDasl.g:671:4: 'EventCorrelation'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getEventCorrelationEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDasl.g:675:2: ( ( 'SecurityAuditLogMonitoring' ) )
                    {
                    // InternalDasl.g:675:2: ( ( 'SecurityAuditLogMonitoring' ) )
                    // InternalDasl.g:676:3: ( 'SecurityAuditLogMonitoring' )
                    {
                     before(grammarAccess.getControlTypeAccess().getSecurityAuditLogMonitoringEnumLiteralDeclaration_35()); 
                    // InternalDasl.g:677:3: ( 'SecurityAuditLogMonitoring' )
                    // InternalDasl.g:677:4: 'SecurityAuditLogMonitoring'
                    {
                    match(input,49,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getSecurityAuditLogMonitoringEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDasl.g:681:2: ( ( 'ComplianceTesting' ) )
                    {
                    // InternalDasl.g:681:2: ( ( 'ComplianceTesting' ) )
                    // InternalDasl.g:682:3: ( 'ComplianceTesting' )
                    {
                     before(grammarAccess.getControlTypeAccess().getComplianceTestingEnumLiteralDeclaration_36()); 
                    // InternalDasl.g:683:3: ( 'ComplianceTesting' )
                    // InternalDasl.g:683:4: 'ComplianceTesting'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getComplianceTestingEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalDasl.g:687:2: ( ( 'IncidentManagement' ) )
                    {
                    // InternalDasl.g:687:2: ( ( 'IncidentManagement' ) )
                    // InternalDasl.g:688:3: ( 'IncidentManagement' )
                    {
                     before(grammarAccess.getControlTypeAccess().getIncidentManagementEnumLiteralDeclaration_37()); 
                    // InternalDasl.g:689:3: ( 'IncidentManagement' )
                    // InternalDasl.g:689:4: 'IncidentManagement'
                    {
                    match(input,51,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getIncidentManagementEnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalDasl.g:693:2: ( ( 'Forensic' ) )
                    {
                    // InternalDasl.g:693:2: ( ( 'Forensic' ) )
                    // InternalDasl.g:694:3: ( 'Forensic' )
                    {
                     before(grammarAccess.getControlTypeAccess().getForensicEnumLiteralDeclaration_38()); 
                    // InternalDasl.g:695:3: ( 'Forensic' )
                    // InternalDasl.g:695:4: 'Forensic'
                    {
                    match(input,52,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getForensicEnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalDasl.g:699:2: ( ( 'Legal' ) )
                    {
                    // InternalDasl.g:699:2: ( ( 'Legal' ) )
                    // InternalDasl.g:700:3: ( 'Legal' )
                    {
                     before(grammarAccess.getControlTypeAccess().getLegalEnumLiteralDeclaration_39()); 
                    // InternalDasl.g:701:3: ( 'Legal' )
                    // InternalDasl.g:701:4: 'Legal'
                    {
                    match(input,53,FOLLOW_2); 

                    }

                     after(grammarAccess.getControlTypeAccess().getLegalEnumLiteralDeclaration_39()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ControlType__Alternatives"


    // $ANTLR start "rule__ConfidentialityType__Alternatives"
    // InternalDasl.g:709:1: rule__ConfidentialityType__Alternatives : ( ( ( 'Public' ) ) | ( ( 'Internal' ) ) | ( ( 'Restricted' ) ) );
    public final void rule__ConfidentialityType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:713:1: ( ( ( 'Public' ) ) | ( ( 'Internal' ) ) | ( ( 'Restricted' ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt5=1;
                }
                break;
            case 55:
                {
                alt5=2;
                }
                break;
            case 56:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDasl.g:714:2: ( ( 'Public' ) )
                    {
                    // InternalDasl.g:714:2: ( ( 'Public' ) )
                    // InternalDasl.g:715:3: ( 'Public' )
                    {
                     before(grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0()); 
                    // InternalDasl.g:716:3: ( 'Public' )
                    // InternalDasl.g:716:4: 'Public'
                    {
                    match(input,54,FOLLOW_2); 

                    }

                     after(grammarAccess.getConfidentialityTypeAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:720:2: ( ( 'Internal' ) )
                    {
                    // InternalDasl.g:720:2: ( ( 'Internal' ) )
                    // InternalDasl.g:721:3: ( 'Internal' )
                    {
                     before(grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1()); 
                    // InternalDasl.g:722:3: ( 'Internal' )
                    // InternalDasl.g:722:4: 'Internal'
                    {
                    match(input,55,FOLLOW_2); 

                    }

                     after(grammarAccess.getConfidentialityTypeAccess().getInternalEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:726:2: ( ( 'Restricted' ) )
                    {
                    // InternalDasl.g:726:2: ( ( 'Restricted' ) )
                    // InternalDasl.g:727:3: ( 'Restricted' )
                    {
                     before(grammarAccess.getConfidentialityTypeAccess().getRestrictedEnumLiteralDeclaration_2()); 
                    // InternalDasl.g:728:3: ( 'Restricted' )
                    // InternalDasl.g:728:4: 'Restricted'
                    {
                    match(input,56,FOLLOW_2); 

                    }

                     after(grammarAccess.getConfidentialityTypeAccess().getRestrictedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfidentialityType__Alternatives"


    // $ANTLR start "rule__IntegrityType__Alternatives"
    // InternalDasl.g:736:1: rule__IntegrityType__Alternatives : ( ( ( 'Accurate' ) ) | ( ( 'HighlyTrusted' ) ) | ( ( 'Trusted' ) ) | ( ( 'Uncontrolled' ) ) );
    public final void rule__IntegrityType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:740:1: ( ( ( 'Accurate' ) ) | ( ( 'HighlyTrusted' ) ) | ( ( 'Trusted' ) ) | ( ( 'Uncontrolled' ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt6=1;
                }
                break;
            case 58:
                {
                alt6=2;
                }
                break;
            case 59:
                {
                alt6=3;
                }
                break;
            case 60:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDasl.g:741:2: ( ( 'Accurate' ) )
                    {
                    // InternalDasl.g:741:2: ( ( 'Accurate' ) )
                    // InternalDasl.g:742:3: ( 'Accurate' )
                    {
                     before(grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0()); 
                    // InternalDasl.g:743:3: ( 'Accurate' )
                    // InternalDasl.g:743:4: 'Accurate'
                    {
                    match(input,57,FOLLOW_2); 

                    }

                     after(grammarAccess.getIntegrityTypeAccess().getAccurateEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:747:2: ( ( 'HighlyTrusted' ) )
                    {
                    // InternalDasl.g:747:2: ( ( 'HighlyTrusted' ) )
                    // InternalDasl.g:748:3: ( 'HighlyTrusted' )
                    {
                     before(grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1()); 
                    // InternalDasl.g:749:3: ( 'HighlyTrusted' )
                    // InternalDasl.g:749:4: 'HighlyTrusted'
                    {
                    match(input,58,FOLLOW_2); 

                    }

                     after(grammarAccess.getIntegrityTypeAccess().getHighlyTrustedEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:753:2: ( ( 'Trusted' ) )
                    {
                    // InternalDasl.g:753:2: ( ( 'Trusted' ) )
                    // InternalDasl.g:754:3: ( 'Trusted' )
                    {
                     before(grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2()); 
                    // InternalDasl.g:755:3: ( 'Trusted' )
                    // InternalDasl.g:755:4: 'Trusted'
                    {
                    match(input,59,FOLLOW_2); 

                    }

                     after(grammarAccess.getIntegrityTypeAccess().getTrustedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:759:2: ( ( 'Uncontrolled' ) )
                    {
                    // InternalDasl.g:759:2: ( ( 'Uncontrolled' ) )
                    // InternalDasl.g:760:3: ( 'Uncontrolled' )
                    {
                     before(grammarAccess.getIntegrityTypeAccess().getUncontrolledEnumLiteralDeclaration_3()); 
                    // InternalDasl.g:761:3: ( 'Uncontrolled' )
                    // InternalDasl.g:761:4: 'Uncontrolled'
                    {
                    match(input,60,FOLLOW_2); 

                    }

                     after(grammarAccess.getIntegrityTypeAccess().getUncontrolledEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrityType__Alternatives"


    // $ANTLR start "rule__AvailabilityType__Alternatives"
    // InternalDasl.g:769:1: rule__AvailabilityType__Alternatives : ( ( ( 'Platinum' ) ) | ( ( 'Gold' ) ) | ( ( 'Silver' ) ) | ( ( 'Bronze' ) ) | ( ( 'Plastic' ) ) );
    public final void rule__AvailabilityType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:773:1: ( ( ( 'Platinum' ) ) | ( ( 'Gold' ) ) | ( ( 'Silver' ) ) | ( ( 'Bronze' ) ) | ( ( 'Plastic' ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt7=1;
                }
                break;
            case 62:
                {
                alt7=2;
                }
                break;
            case 63:
                {
                alt7=3;
                }
                break;
            case 64:
                {
                alt7=4;
                }
                break;
            case 65:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalDasl.g:774:2: ( ( 'Platinum' ) )
                    {
                    // InternalDasl.g:774:2: ( ( 'Platinum' ) )
                    // InternalDasl.g:775:3: ( 'Platinum' )
                    {
                     before(grammarAccess.getAvailabilityTypeAccess().getPlatinumEnumLiteralDeclaration_0()); 
                    // InternalDasl.g:776:3: ( 'Platinum' )
                    // InternalDasl.g:776:4: 'Platinum'
                    {
                    match(input,61,FOLLOW_2); 

                    }

                     after(grammarAccess.getAvailabilityTypeAccess().getPlatinumEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDasl.g:780:2: ( ( 'Gold' ) )
                    {
                    // InternalDasl.g:780:2: ( ( 'Gold' ) )
                    // InternalDasl.g:781:3: ( 'Gold' )
                    {
                     before(grammarAccess.getAvailabilityTypeAccess().getGoldEnumLiteralDeclaration_1()); 
                    // InternalDasl.g:782:3: ( 'Gold' )
                    // InternalDasl.g:782:4: 'Gold'
                    {
                    match(input,62,FOLLOW_2); 

                    }

                     after(grammarAccess.getAvailabilityTypeAccess().getGoldEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDasl.g:786:2: ( ( 'Silver' ) )
                    {
                    // InternalDasl.g:786:2: ( ( 'Silver' ) )
                    // InternalDasl.g:787:3: ( 'Silver' )
                    {
                     before(grammarAccess.getAvailabilityTypeAccess().getSilverEnumLiteralDeclaration_2()); 
                    // InternalDasl.g:788:3: ( 'Silver' )
                    // InternalDasl.g:788:4: 'Silver'
                    {
                    match(input,63,FOLLOW_2); 

                    }

                     after(grammarAccess.getAvailabilityTypeAccess().getSilverEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDasl.g:792:2: ( ( 'Bronze' ) )
                    {
                    // InternalDasl.g:792:2: ( ( 'Bronze' ) )
                    // InternalDasl.g:793:3: ( 'Bronze' )
                    {
                     before(grammarAccess.getAvailabilityTypeAccess().getBronzeEnumLiteralDeclaration_3()); 
                    // InternalDasl.g:794:3: ( 'Bronze' )
                    // InternalDasl.g:794:4: 'Bronze'
                    {
                    match(input,64,FOLLOW_2); 

                    }

                     after(grammarAccess.getAvailabilityTypeAccess().getBronzeEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDasl.g:798:2: ( ( 'Plastic' ) )
                    {
                    // InternalDasl.g:798:2: ( ( 'Plastic' ) )
                    // InternalDasl.g:799:3: ( 'Plastic' )
                    {
                     before(grammarAccess.getAvailabilityTypeAccess().getPlasticEnumLiteralDeclaration_4()); 
                    // InternalDasl.g:800:3: ( 'Plastic' )
                    // InternalDasl.g:800:4: 'Plastic'
                    {
                    match(input,65,FOLLOW_2); 

                    }

                     after(grammarAccess.getAvailabilityTypeAccess().getPlasticEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AvailabilityType__Alternatives"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalDasl.g:808:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:812:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalDasl.g:813:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalDasl.g:820:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:824:1: ( ( RULE_ID ) )
            // InternalDasl.g:825:1: ( RULE_ID )
            {
            // InternalDasl.g:825:1: ( RULE_ID )
            // InternalDasl.g:826:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalDasl.g:835:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:839:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalDasl.g:840:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalDasl.g:846:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:850:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalDasl.g:851:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalDasl.g:851:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalDasl.g:852:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalDasl.g:853:2: ( rule__QualifiedName__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==66) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDasl.g:853:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalDasl.g:862:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:866:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalDasl.g:867:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalDasl.g:874:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:878:1: ( ( '.' ) )
            // InternalDasl.g:879:1: ( '.' )
            {
            // InternalDasl.g:879:1: ( '.' )
            // InternalDasl.g:880:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalDasl.g:889:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:893:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalDasl.g:894:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalDasl.g:900:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:904:1: ( ( RULE_ID ) )
            // InternalDasl.g:905:1: ( RULE_ID )
            {
            // InternalDasl.g:905:1: ( RULE_ID )
            // InternalDasl.g:906:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalDasl.g:916:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:920:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalDasl.g:921:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalDasl.g:928:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:932:1: ( ( 'import' ) )
            // InternalDasl.g:933:1: ( 'import' )
            {
            // InternalDasl.g:933:1: ( 'import' )
            // InternalDasl.g:934:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalDasl.g:943:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:947:1: ( rule__Import__Group__1__Impl )
            // InternalDasl.g:948:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalDasl.g:954:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:958:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // InternalDasl.g:959:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // InternalDasl.g:959:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // InternalDasl.g:960:2: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // InternalDasl.g:961:2: ( rule__Import__ImportURIAssignment_1 )
            // InternalDasl.g:961:3: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Zone__Group__0"
    // InternalDasl.g:970:1: rule__Zone__Group__0 : rule__Zone__Group__0__Impl rule__Zone__Group__1 ;
    public final void rule__Zone__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:974:1: ( rule__Zone__Group__0__Impl rule__Zone__Group__1 )
            // InternalDasl.g:975:2: rule__Zone__Group__0__Impl rule__Zone__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Zone__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__0"


    // $ANTLR start "rule__Zone__Group__0__Impl"
    // InternalDasl.g:982:1: rule__Zone__Group__0__Impl : ( 'zone' ) ;
    public final void rule__Zone__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:986:1: ( ( 'zone' ) )
            // InternalDasl.g:987:1: ( 'zone' )
            {
            // InternalDasl.g:987:1: ( 'zone' )
            // InternalDasl.g:988:2: 'zone'
            {
             before(grammarAccess.getZoneAccess().getZoneKeyword_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getZoneKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__0__Impl"


    // $ANTLR start "rule__Zone__Group__1"
    // InternalDasl.g:997:1: rule__Zone__Group__1 : rule__Zone__Group__1__Impl rule__Zone__Group__2 ;
    public final void rule__Zone__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1001:1: ( rule__Zone__Group__1__Impl rule__Zone__Group__2 )
            // InternalDasl.g:1002:2: rule__Zone__Group__1__Impl rule__Zone__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Zone__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__1"


    // $ANTLR start "rule__Zone__Group__1__Impl"
    // InternalDasl.g:1009:1: rule__Zone__Group__1__Impl : ( ( rule__Zone__NameAssignment_1 ) ) ;
    public final void rule__Zone__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1013:1: ( ( ( rule__Zone__NameAssignment_1 ) ) )
            // InternalDasl.g:1014:1: ( ( rule__Zone__NameAssignment_1 ) )
            {
            // InternalDasl.g:1014:1: ( ( rule__Zone__NameAssignment_1 ) )
            // InternalDasl.g:1015:2: ( rule__Zone__NameAssignment_1 )
            {
             before(grammarAccess.getZoneAccess().getNameAssignment_1()); 
            // InternalDasl.g:1016:2: ( rule__Zone__NameAssignment_1 )
            // InternalDasl.g:1016:3: rule__Zone__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Zone__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getZoneAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__1__Impl"


    // $ANTLR start "rule__Zone__Group__2"
    // InternalDasl.g:1024:1: rule__Zone__Group__2 : rule__Zone__Group__2__Impl rule__Zone__Group__3 ;
    public final void rule__Zone__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1028:1: ( rule__Zone__Group__2__Impl rule__Zone__Group__3 )
            // InternalDasl.g:1029:2: rule__Zone__Group__2__Impl rule__Zone__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Zone__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__2"


    // $ANTLR start "rule__Zone__Group__2__Impl"
    // InternalDasl.g:1036:1: rule__Zone__Group__2__Impl : ( '{' ) ;
    public final void rule__Zone__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1040:1: ( ( '{' ) )
            // InternalDasl.g:1041:1: ( '{' )
            {
            // InternalDasl.g:1041:1: ( '{' )
            // InternalDasl.g:1042:2: '{'
            {
             before(grammarAccess.getZoneAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__2__Impl"


    // $ANTLR start "rule__Zone__Group__3"
    // InternalDasl.g:1051:1: rule__Zone__Group__3 : rule__Zone__Group__3__Impl rule__Zone__Group__4 ;
    public final void rule__Zone__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1055:1: ( rule__Zone__Group__3__Impl rule__Zone__Group__4 )
            // InternalDasl.g:1056:2: rule__Zone__Group__3__Impl rule__Zone__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Zone__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__3"


    // $ANTLR start "rule__Zone__Group__3__Impl"
    // InternalDasl.g:1063:1: rule__Zone__Group__3__Impl : ( 'trustLevel' ) ;
    public final void rule__Zone__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1067:1: ( ( 'trustLevel' ) )
            // InternalDasl.g:1068:1: ( 'trustLevel' )
            {
            // InternalDasl.g:1068:1: ( 'trustLevel' )
            // InternalDasl.g:1069:2: 'trustLevel'
            {
             before(grammarAccess.getZoneAccess().getTrustLevelKeyword_3()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getTrustLevelKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__3__Impl"


    // $ANTLR start "rule__Zone__Group__4"
    // InternalDasl.g:1078:1: rule__Zone__Group__4 : rule__Zone__Group__4__Impl rule__Zone__Group__5 ;
    public final void rule__Zone__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1082:1: ( rule__Zone__Group__4__Impl rule__Zone__Group__5 )
            // InternalDasl.g:1083:2: rule__Zone__Group__4__Impl rule__Zone__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Zone__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__4"


    // $ANTLR start "rule__Zone__Group__4__Impl"
    // InternalDasl.g:1090:1: rule__Zone__Group__4__Impl : ( ( rule__Zone__TrustAssignment_4 ) ) ;
    public final void rule__Zone__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1094:1: ( ( ( rule__Zone__TrustAssignment_4 ) ) )
            // InternalDasl.g:1095:1: ( ( rule__Zone__TrustAssignment_4 ) )
            {
            // InternalDasl.g:1095:1: ( ( rule__Zone__TrustAssignment_4 ) )
            // InternalDasl.g:1096:2: ( rule__Zone__TrustAssignment_4 )
            {
             before(grammarAccess.getZoneAccess().getTrustAssignment_4()); 
            // InternalDasl.g:1097:2: ( rule__Zone__TrustAssignment_4 )
            // InternalDasl.g:1097:3: rule__Zone__TrustAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Zone__TrustAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getZoneAccess().getTrustAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__4__Impl"


    // $ANTLR start "rule__Zone__Group__5"
    // InternalDasl.g:1105:1: rule__Zone__Group__5 : rule__Zone__Group__5__Impl rule__Zone__Group__6 ;
    public final void rule__Zone__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1109:1: ( rule__Zone__Group__5__Impl rule__Zone__Group__6 )
            // InternalDasl.g:1110:2: rule__Zone__Group__5__Impl rule__Zone__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__Zone__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__5"


    // $ANTLR start "rule__Zone__Group__5__Impl"
    // InternalDasl.g:1117:1: rule__Zone__Group__5__Impl : ( 'ingress' ) ;
    public final void rule__Zone__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1121:1: ( ( 'ingress' ) )
            // InternalDasl.g:1122:1: ( 'ingress' )
            {
            // InternalDasl.g:1122:1: ( 'ingress' )
            // InternalDasl.g:1123:2: 'ingress'
            {
             before(grammarAccess.getZoneAccess().getIngressKeyword_5()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getIngressKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__5__Impl"


    // $ANTLR start "rule__Zone__Group__6"
    // InternalDasl.g:1132:1: rule__Zone__Group__6 : rule__Zone__Group__6__Impl rule__Zone__Group__7 ;
    public final void rule__Zone__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1136:1: ( rule__Zone__Group__6__Impl rule__Zone__Group__7 )
            // InternalDasl.g:1137:2: rule__Zone__Group__6__Impl rule__Zone__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__Zone__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__6"


    // $ANTLR start "rule__Zone__Group__6__Impl"
    // InternalDasl.g:1144:1: rule__Zone__Group__6__Impl : ( ( rule__Zone__IngressZonesAssignment_6 )* ) ;
    public final void rule__Zone__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1148:1: ( ( ( rule__Zone__IngressZonesAssignment_6 )* ) )
            // InternalDasl.g:1149:1: ( ( rule__Zone__IngressZonesAssignment_6 )* )
            {
            // InternalDasl.g:1149:1: ( ( rule__Zone__IngressZonesAssignment_6 )* )
            // InternalDasl.g:1150:2: ( rule__Zone__IngressZonesAssignment_6 )*
            {
             before(grammarAccess.getZoneAccess().getIngressZonesAssignment_6()); 
            // InternalDasl.g:1151:2: ( rule__Zone__IngressZonesAssignment_6 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDasl.g:1151:3: rule__Zone__IngressZonesAssignment_6
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Zone__IngressZonesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getZoneAccess().getIngressZonesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__6__Impl"


    // $ANTLR start "rule__Zone__Group__7"
    // InternalDasl.g:1159:1: rule__Zone__Group__7 : rule__Zone__Group__7__Impl rule__Zone__Group__8 ;
    public final void rule__Zone__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1163:1: ( rule__Zone__Group__7__Impl rule__Zone__Group__8 )
            // InternalDasl.g:1164:2: rule__Zone__Group__7__Impl rule__Zone__Group__8
            {
            pushFollow(FOLLOW_14);
            rule__Zone__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__7"


    // $ANTLR start "rule__Zone__Group__7__Impl"
    // InternalDasl.g:1171:1: rule__Zone__Group__7__Impl : ( 'egress' ) ;
    public final void rule__Zone__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1175:1: ( ( 'egress' ) )
            // InternalDasl.g:1176:1: ( 'egress' )
            {
            // InternalDasl.g:1176:1: ( 'egress' )
            // InternalDasl.g:1177:2: 'egress'
            {
             before(grammarAccess.getZoneAccess().getEgressKeyword_7()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getEgressKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__7__Impl"


    // $ANTLR start "rule__Zone__Group__8"
    // InternalDasl.g:1186:1: rule__Zone__Group__8 : rule__Zone__Group__8__Impl rule__Zone__Group__9 ;
    public final void rule__Zone__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1190:1: ( rule__Zone__Group__8__Impl rule__Zone__Group__9 )
            // InternalDasl.g:1191:2: rule__Zone__Group__8__Impl rule__Zone__Group__9
            {
            pushFollow(FOLLOW_14);
            rule__Zone__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__8"


    // $ANTLR start "rule__Zone__Group__8__Impl"
    // InternalDasl.g:1198:1: rule__Zone__Group__8__Impl : ( ( rule__Zone__EgressZonesAssignment_8 )* ) ;
    public final void rule__Zone__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1202:1: ( ( ( rule__Zone__EgressZonesAssignment_8 )* ) )
            // InternalDasl.g:1203:1: ( ( rule__Zone__EgressZonesAssignment_8 )* )
            {
            // InternalDasl.g:1203:1: ( ( rule__Zone__EgressZonesAssignment_8 )* )
            // InternalDasl.g:1204:2: ( rule__Zone__EgressZonesAssignment_8 )*
            {
             before(grammarAccess.getZoneAccess().getEgressZonesAssignment_8()); 
            // InternalDasl.g:1205:2: ( rule__Zone__EgressZonesAssignment_8 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDasl.g:1205:3: rule__Zone__EgressZonesAssignment_8
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Zone__EgressZonesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getZoneAccess().getEgressZonesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__8__Impl"


    // $ANTLR start "rule__Zone__Group__9"
    // InternalDasl.g:1213:1: rule__Zone__Group__9 : rule__Zone__Group__9__Impl rule__Zone__Group__10 ;
    public final void rule__Zone__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1217:1: ( rule__Zone__Group__9__Impl rule__Zone__Group__10 )
            // InternalDasl.g:1218:2: rule__Zone__Group__9__Impl rule__Zone__Group__10
            {
            pushFollow(FOLLOW_15);
            rule__Zone__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__9"


    // $ANTLR start "rule__Zone__Group__9__Impl"
    // InternalDasl.g:1225:1: rule__Zone__Group__9__Impl : ( 'nodes' ) ;
    public final void rule__Zone__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1229:1: ( ( 'nodes' ) )
            // InternalDasl.g:1230:1: ( 'nodes' )
            {
            // InternalDasl.g:1230:1: ( 'nodes' )
            // InternalDasl.g:1231:2: 'nodes'
            {
             before(grammarAccess.getZoneAccess().getNodesKeyword_9()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getNodesKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__9__Impl"


    // $ANTLR start "rule__Zone__Group__10"
    // InternalDasl.g:1240:1: rule__Zone__Group__10 : rule__Zone__Group__10__Impl rule__Zone__Group__11 ;
    public final void rule__Zone__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1244:1: ( rule__Zone__Group__10__Impl rule__Zone__Group__11 )
            // InternalDasl.g:1245:2: rule__Zone__Group__10__Impl rule__Zone__Group__11
            {
            pushFollow(FOLLOW_15);
            rule__Zone__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__10"


    // $ANTLR start "rule__Zone__Group__10__Impl"
    // InternalDasl.g:1252:1: rule__Zone__Group__10__Impl : ( ( rule__Zone__NodesAssignment_10 )* ) ;
    public final void rule__Zone__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1256:1: ( ( ( rule__Zone__NodesAssignment_10 )* ) )
            // InternalDasl.g:1257:1: ( ( rule__Zone__NodesAssignment_10 )* )
            {
            // InternalDasl.g:1257:1: ( ( rule__Zone__NodesAssignment_10 )* )
            // InternalDasl.g:1258:2: ( rule__Zone__NodesAssignment_10 )*
            {
             before(grammarAccess.getZoneAccess().getNodesAssignment_10()); 
            // InternalDasl.g:1259:2: ( rule__Zone__NodesAssignment_10 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDasl.g:1259:3: rule__Zone__NodesAssignment_10
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Zone__NodesAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getZoneAccess().getNodesAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__10__Impl"


    // $ANTLR start "rule__Zone__Group__11"
    // InternalDasl.g:1267:1: rule__Zone__Group__11 : rule__Zone__Group__11__Impl rule__Zone__Group__12 ;
    public final void rule__Zone__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1271:1: ( rule__Zone__Group__11__Impl rule__Zone__Group__12 )
            // InternalDasl.g:1272:2: rule__Zone__Group__11__Impl rule__Zone__Group__12
            {
            pushFollow(FOLLOW_15);
            rule__Zone__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__11"


    // $ANTLR start "rule__Zone__Group__11__Impl"
    // InternalDasl.g:1279:1: rule__Zone__Group__11__Impl : ( ( rule__Zone__Group_11__0 )? ) ;
    public final void rule__Zone__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1283:1: ( ( ( rule__Zone__Group_11__0 )? ) )
            // InternalDasl.g:1284:1: ( ( rule__Zone__Group_11__0 )? )
            {
            // InternalDasl.g:1284:1: ( ( rule__Zone__Group_11__0 )? )
            // InternalDasl.g:1285:2: ( rule__Zone__Group_11__0 )?
            {
             before(grammarAccess.getZoneAccess().getGroup_11()); 
            // InternalDasl.g:1286:2: ( rule__Zone__Group_11__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==75) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDasl.g:1286:3: rule__Zone__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Zone__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getZoneAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__11__Impl"


    // $ANTLR start "rule__Zone__Group__12"
    // InternalDasl.g:1294:1: rule__Zone__Group__12 : rule__Zone__Group__12__Impl ;
    public final void rule__Zone__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1298:1: ( rule__Zone__Group__12__Impl )
            // InternalDasl.g:1299:2: rule__Zone__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Zone__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__12"


    // $ANTLR start "rule__Zone__Group__12__Impl"
    // InternalDasl.g:1305:1: rule__Zone__Group__12__Impl : ( '}' ) ;
    public final void rule__Zone__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1309:1: ( ( '}' ) )
            // InternalDasl.g:1310:1: ( '}' )
            {
            // InternalDasl.g:1310:1: ( '}' )
            // InternalDasl.g:1311:2: '}'
            {
             before(grammarAccess.getZoneAccess().getRightCurlyBracketKeyword_12()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group__12__Impl"


    // $ANTLR start "rule__Zone__Group_11__0"
    // InternalDasl.g:1321:1: rule__Zone__Group_11__0 : rule__Zone__Group_11__0__Impl rule__Zone__Group_11__1 ;
    public final void rule__Zone__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1325:1: ( rule__Zone__Group_11__0__Impl rule__Zone__Group_11__1 )
            // InternalDasl.g:1326:2: rule__Zone__Group_11__0__Impl rule__Zone__Group_11__1
            {
            pushFollow(FOLLOW_6);
            rule__Zone__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Zone__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group_11__0"


    // $ANTLR start "rule__Zone__Group_11__0__Impl"
    // InternalDasl.g:1333:1: rule__Zone__Group_11__0__Impl : ( 'controls' ) ;
    public final void rule__Zone__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1337:1: ( ( 'controls' ) )
            // InternalDasl.g:1338:1: ( 'controls' )
            {
            // InternalDasl.g:1338:1: ( 'controls' )
            // InternalDasl.g:1339:2: 'controls'
            {
             before(grammarAccess.getZoneAccess().getControlsKeyword_11_0()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getControlsKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group_11__0__Impl"


    // $ANTLR start "rule__Zone__Group_11__1"
    // InternalDasl.g:1348:1: rule__Zone__Group_11__1 : rule__Zone__Group_11__1__Impl ;
    public final void rule__Zone__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1352:1: ( rule__Zone__Group_11__1__Impl )
            // InternalDasl.g:1353:2: rule__Zone__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Zone__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group_11__1"


    // $ANTLR start "rule__Zone__Group_11__1__Impl"
    // InternalDasl.g:1359:1: rule__Zone__Group_11__1__Impl : ( ( rule__Zone__ControlsAssignment_11_1 ) ) ;
    public final void rule__Zone__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1363:1: ( ( ( rule__Zone__ControlsAssignment_11_1 ) ) )
            // InternalDasl.g:1364:1: ( ( rule__Zone__ControlsAssignment_11_1 ) )
            {
            // InternalDasl.g:1364:1: ( ( rule__Zone__ControlsAssignment_11_1 ) )
            // InternalDasl.g:1365:2: ( rule__Zone__ControlsAssignment_11_1 )
            {
             before(grammarAccess.getZoneAccess().getControlsAssignment_11_1()); 
            // InternalDasl.g:1366:2: ( rule__Zone__ControlsAssignment_11_1 )
            // InternalDasl.g:1366:3: rule__Zone__ControlsAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__Zone__ControlsAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getZoneAccess().getControlsAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__Group_11__1__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // InternalDasl.g:1375:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1379:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalDasl.g:1380:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0"


    // $ANTLR start "rule__Node__Group__0__Impl"
    // InternalDasl.g:1387:1: rule__Node__Group__0__Impl : ( 'node' ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1391:1: ( ( 'node' ) )
            // InternalDasl.g:1392:1: ( 'node' )
            {
            // InternalDasl.g:1392:1: ( 'node' )
            // InternalDasl.g:1393:2: 'node'
            {
             before(grammarAccess.getNodeAccess().getNodeKeyword_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getNodeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0__Impl"


    // $ANTLR start "rule__Node__Group__1"
    // InternalDasl.g:1402:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1406:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalDasl.g:1407:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1"


    // $ANTLR start "rule__Node__Group__1__Impl"
    // InternalDasl.g:1414:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1418:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // InternalDasl.g:1419:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // InternalDasl.g:1419:1: ( ( rule__Node__NameAssignment_1 ) )
            // InternalDasl.g:1420:2: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // InternalDasl.g:1421:2: ( rule__Node__NameAssignment_1 )
            // InternalDasl.g:1421:3: rule__Node__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1__Impl"


    // $ANTLR start "rule__Node__Group__2"
    // InternalDasl.g:1429:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1433:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalDasl.g:1434:2: rule__Node__Group__2__Impl rule__Node__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Node__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2"


    // $ANTLR start "rule__Node__Group__2__Impl"
    // InternalDasl.g:1441:1: rule__Node__Group__2__Impl : ( '{' ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1445:1: ( ( '{' ) )
            // InternalDasl.g:1446:1: ( '{' )
            {
            // InternalDasl.g:1446:1: ( '{' )
            // InternalDasl.g:1447:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2__Impl"


    // $ANTLR start "rule__Node__Group__3"
    // InternalDasl.g:1456:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1460:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalDasl.g:1461:2: rule__Node__Group__3__Impl rule__Node__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Node__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3"


    // $ANTLR start "rule__Node__Group__3__Impl"
    // InternalDasl.g:1468:1: rule__Node__Group__3__Impl : ( 'ref' ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1472:1: ( ( 'ref' ) )
            // InternalDasl.g:1473:1: ( 'ref' )
            {
            // InternalDasl.g:1473:1: ( 'ref' )
            // InternalDasl.g:1474:2: 'ref'
            {
             before(grammarAccess.getNodeAccess().getRefKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRefKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3__Impl"


    // $ANTLR start "rule__Node__Group__4"
    // InternalDasl.g:1483:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1487:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // InternalDasl.g:1488:2: rule__Node__Group__4__Impl rule__Node__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__Node__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4"


    // $ANTLR start "rule__Node__Group__4__Impl"
    // InternalDasl.g:1495:1: rule__Node__Group__4__Impl : ( ( rule__Node__RefAssignment_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1499:1: ( ( ( rule__Node__RefAssignment_4 ) ) )
            // InternalDasl.g:1500:1: ( ( rule__Node__RefAssignment_4 ) )
            {
            // InternalDasl.g:1500:1: ( ( rule__Node__RefAssignment_4 ) )
            // InternalDasl.g:1501:2: ( rule__Node__RefAssignment_4 )
            {
             before(grammarAccess.getNodeAccess().getRefAssignment_4()); 
            // InternalDasl.g:1502:2: ( rule__Node__RefAssignment_4 )
            // InternalDasl.g:1502:3: rule__Node__RefAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Node__RefAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getRefAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4__Impl"


    // $ANTLR start "rule__Node__Group__5"
    // InternalDasl.g:1510:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1514:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // InternalDasl.g:1515:2: rule__Node__Group__5__Impl rule__Node__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Node__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__5"


    // $ANTLR start "rule__Node__Group__5__Impl"
    // InternalDasl.g:1522:1: rule__Node__Group__5__Impl : ( 'host' ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1526:1: ( ( 'host' ) )
            // InternalDasl.g:1527:1: ( 'host' )
            {
            // InternalDasl.g:1527:1: ( 'host' )
            // InternalDasl.g:1528:2: 'host'
            {
             before(grammarAccess.getNodeAccess().getHostKeyword_5()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getHostKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__5__Impl"


    // $ANTLR start "rule__Node__Group__6"
    // InternalDasl.g:1537:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1541:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // InternalDasl.g:1542:2: rule__Node__Group__6__Impl rule__Node__Group__7
            {
            pushFollow(FOLLOW_18);
            rule__Node__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__6"


    // $ANTLR start "rule__Node__Group__6__Impl"
    // InternalDasl.g:1549:1: rule__Node__Group__6__Impl : ( ( rule__Node__HostAssignment_6 ) ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1553:1: ( ( ( rule__Node__HostAssignment_6 ) ) )
            // InternalDasl.g:1554:1: ( ( rule__Node__HostAssignment_6 ) )
            {
            // InternalDasl.g:1554:1: ( ( rule__Node__HostAssignment_6 ) )
            // InternalDasl.g:1555:2: ( rule__Node__HostAssignment_6 )
            {
             before(grammarAccess.getNodeAccess().getHostAssignment_6()); 
            // InternalDasl.g:1556:2: ( rule__Node__HostAssignment_6 )
            // InternalDasl.g:1556:3: rule__Node__HostAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Node__HostAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getHostAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__6__Impl"


    // $ANTLR start "rule__Node__Group__7"
    // InternalDasl.g:1564:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1568:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // InternalDasl.g:1569:2: rule__Node__Group__7__Impl rule__Node__Group__8
            {
            pushFollow(FOLLOW_7);
            rule__Node__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__7"


    // $ANTLR start "rule__Node__Group__7__Impl"
    // InternalDasl.g:1576:1: rule__Node__Group__7__Impl : ( 'os' ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1580:1: ( ( 'os' ) )
            // InternalDasl.g:1581:1: ( 'os' )
            {
            // InternalDasl.g:1581:1: ( 'os' )
            // InternalDasl.g:1582:2: 'os'
            {
             before(grammarAccess.getNodeAccess().getOsKeyword_7()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getOsKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__7__Impl"


    // $ANTLR start "rule__Node__Group__8"
    // InternalDasl.g:1591:1: rule__Node__Group__8 : rule__Node__Group__8__Impl rule__Node__Group__9 ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1595:1: ( rule__Node__Group__8__Impl rule__Node__Group__9 )
            // InternalDasl.g:1596:2: rule__Node__Group__8__Impl rule__Node__Group__9
            {
            pushFollow(FOLLOW_19);
            rule__Node__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__8"


    // $ANTLR start "rule__Node__Group__8__Impl"
    // InternalDasl.g:1603:1: rule__Node__Group__8__Impl : ( ( rule__Node__OsAssignment_8 ) ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1607:1: ( ( ( rule__Node__OsAssignment_8 ) ) )
            // InternalDasl.g:1608:1: ( ( rule__Node__OsAssignment_8 ) )
            {
            // InternalDasl.g:1608:1: ( ( rule__Node__OsAssignment_8 ) )
            // InternalDasl.g:1609:2: ( rule__Node__OsAssignment_8 )
            {
             before(grammarAccess.getNodeAccess().getOsAssignment_8()); 
            // InternalDasl.g:1610:2: ( rule__Node__OsAssignment_8 )
            // InternalDasl.g:1610:3: rule__Node__OsAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Node__OsAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getOsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__8__Impl"


    // $ANTLR start "rule__Node__Group__9"
    // InternalDasl.g:1618:1: rule__Node__Group__9 : rule__Node__Group__9__Impl rule__Node__Group__10 ;
    public final void rule__Node__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1622:1: ( rule__Node__Group__9__Impl rule__Node__Group__10 )
            // InternalDasl.g:1623:2: rule__Node__Group__9__Impl rule__Node__Group__10
            {
            pushFollow(FOLLOW_20);
            rule__Node__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__9"


    // $ANTLR start "rule__Node__Group__9__Impl"
    // InternalDasl.g:1630:1: rule__Node__Group__9__Impl : ( 'type' ) ;
    public final void rule__Node__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1634:1: ( ( 'type' ) )
            // InternalDasl.g:1635:1: ( 'type' )
            {
            // InternalDasl.g:1635:1: ( 'type' )
            // InternalDasl.g:1636:2: 'type'
            {
             before(grammarAccess.getNodeAccess().getTypeKeyword_9()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getTypeKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__9__Impl"


    // $ANTLR start "rule__Node__Group__10"
    // InternalDasl.g:1645:1: rule__Node__Group__10 : rule__Node__Group__10__Impl rule__Node__Group__11 ;
    public final void rule__Node__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1649:1: ( rule__Node__Group__10__Impl rule__Node__Group__11 )
            // InternalDasl.g:1650:2: rule__Node__Group__10__Impl rule__Node__Group__11
            {
            pushFollow(FOLLOW_21);
            rule__Node__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__10"


    // $ANTLR start "rule__Node__Group__10__Impl"
    // InternalDasl.g:1657:1: rule__Node__Group__10__Impl : ( ( rule__Node__ValueAssignment_10 ) ) ;
    public final void rule__Node__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1661:1: ( ( ( rule__Node__ValueAssignment_10 ) ) )
            // InternalDasl.g:1662:1: ( ( rule__Node__ValueAssignment_10 ) )
            {
            // InternalDasl.g:1662:1: ( ( rule__Node__ValueAssignment_10 ) )
            // InternalDasl.g:1663:2: ( rule__Node__ValueAssignment_10 )
            {
             before(grammarAccess.getNodeAccess().getValueAssignment_10()); 
            // InternalDasl.g:1664:2: ( rule__Node__ValueAssignment_10 )
            // InternalDasl.g:1664:3: rule__Node__ValueAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Node__ValueAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getValueAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__10__Impl"


    // $ANTLR start "rule__Node__Group__11"
    // InternalDasl.g:1672:1: rule__Node__Group__11 : rule__Node__Group__11__Impl rule__Node__Group__12 ;
    public final void rule__Node__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1676:1: ( rule__Node__Group__11__Impl rule__Node__Group__12 )
            // InternalDasl.g:1677:2: rule__Node__Group__11__Impl rule__Node__Group__12
            {
            pushFollow(FOLLOW_22);
            rule__Node__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__11"


    // $ANTLR start "rule__Node__Group__11__Impl"
    // InternalDasl.g:1684:1: rule__Node__Group__11__Impl : ( 'components' ) ;
    public final void rule__Node__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1688:1: ( ( 'components' ) )
            // InternalDasl.g:1689:1: ( 'components' )
            {
            // InternalDasl.g:1689:1: ( 'components' )
            // InternalDasl.g:1690:2: 'components'
            {
             before(grammarAccess.getNodeAccess().getComponentsKeyword_11()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getComponentsKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__11__Impl"


    // $ANTLR start "rule__Node__Group__12"
    // InternalDasl.g:1699:1: rule__Node__Group__12 : rule__Node__Group__12__Impl rule__Node__Group__13 ;
    public final void rule__Node__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1703:1: ( rule__Node__Group__12__Impl rule__Node__Group__13 )
            // InternalDasl.g:1704:2: rule__Node__Group__12__Impl rule__Node__Group__13
            {
            pushFollow(FOLLOW_22);
            rule__Node__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__12"


    // $ANTLR start "rule__Node__Group__12__Impl"
    // InternalDasl.g:1711:1: rule__Node__Group__12__Impl : ( ( rule__Node__ComponentsAssignment_12 )* ) ;
    public final void rule__Node__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1715:1: ( ( ( rule__Node__ComponentsAssignment_12 )* ) )
            // InternalDasl.g:1716:1: ( ( rule__Node__ComponentsAssignment_12 )* )
            {
            // InternalDasl.g:1716:1: ( ( rule__Node__ComponentsAssignment_12 )* )
            // InternalDasl.g:1717:2: ( rule__Node__ComponentsAssignment_12 )*
            {
             before(grammarAccess.getNodeAccess().getComponentsAssignment_12()); 
            // InternalDasl.g:1718:2: ( rule__Node__ComponentsAssignment_12 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalDasl.g:1718:3: rule__Node__ComponentsAssignment_12
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Node__ComponentsAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getComponentsAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__12__Impl"


    // $ANTLR start "rule__Node__Group__13"
    // InternalDasl.g:1726:1: rule__Node__Group__13 : rule__Node__Group__13__Impl ;
    public final void rule__Node__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1730:1: ( rule__Node__Group__13__Impl )
            // InternalDasl.g:1731:2: rule__Node__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__13"


    // $ANTLR start "rule__Node__Group__13__Impl"
    // InternalDasl.g:1737:1: rule__Node__Group__13__Impl : ( '}' ) ;
    public final void rule__Node__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1741:1: ( ( '}' ) )
            // InternalDasl.g:1742:1: ( '}' )
            {
            // InternalDasl.g:1742:1: ( '}' )
            // InternalDasl.g:1743:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_13()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__13__Impl"


    // $ANTLR start "rule__Component__Group__0"
    // InternalDasl.g:1753:1: rule__Component__Group__0 : rule__Component__Group__0__Impl rule__Component__Group__1 ;
    public final void rule__Component__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1757:1: ( rule__Component__Group__0__Impl rule__Component__Group__1 )
            // InternalDasl.g:1758:2: rule__Component__Group__0__Impl rule__Component__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Component__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__0"


    // $ANTLR start "rule__Component__Group__0__Impl"
    // InternalDasl.g:1765:1: rule__Component__Group__0__Impl : ( 'component' ) ;
    public final void rule__Component__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1769:1: ( ( 'component' ) )
            // InternalDasl.g:1770:1: ( 'component' )
            {
            // InternalDasl.g:1770:1: ( 'component' )
            // InternalDasl.g:1771:2: 'component'
            {
             before(grammarAccess.getComponentAccess().getComponentKeyword_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getComponentKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__0__Impl"


    // $ANTLR start "rule__Component__Group__1"
    // InternalDasl.g:1780:1: rule__Component__Group__1 : rule__Component__Group__1__Impl rule__Component__Group__2 ;
    public final void rule__Component__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1784:1: ( rule__Component__Group__1__Impl rule__Component__Group__2 )
            // InternalDasl.g:1785:2: rule__Component__Group__1__Impl rule__Component__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Component__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__1"


    // $ANTLR start "rule__Component__Group__1__Impl"
    // InternalDasl.g:1792:1: rule__Component__Group__1__Impl : ( ( rule__Component__NameAssignment_1 ) ) ;
    public final void rule__Component__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1796:1: ( ( ( rule__Component__NameAssignment_1 ) ) )
            // InternalDasl.g:1797:1: ( ( rule__Component__NameAssignment_1 ) )
            {
            // InternalDasl.g:1797:1: ( ( rule__Component__NameAssignment_1 ) )
            // InternalDasl.g:1798:2: ( rule__Component__NameAssignment_1 )
            {
             before(grammarAccess.getComponentAccess().getNameAssignment_1()); 
            // InternalDasl.g:1799:2: ( rule__Component__NameAssignment_1 )
            // InternalDasl.g:1799:3: rule__Component__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Component__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__1__Impl"


    // $ANTLR start "rule__Component__Group__2"
    // InternalDasl.g:1807:1: rule__Component__Group__2 : rule__Component__Group__2__Impl rule__Component__Group__3 ;
    public final void rule__Component__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1811:1: ( rule__Component__Group__2__Impl rule__Component__Group__3 )
            // InternalDasl.g:1812:2: rule__Component__Group__2__Impl rule__Component__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Component__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__2"


    // $ANTLR start "rule__Component__Group__2__Impl"
    // InternalDasl.g:1819:1: rule__Component__Group__2__Impl : ( '{' ) ;
    public final void rule__Component__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1823:1: ( ( '{' ) )
            // InternalDasl.g:1824:1: ( '{' )
            {
            // InternalDasl.g:1824:1: ( '{' )
            // InternalDasl.g:1825:2: '{'
            {
             before(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__2__Impl"


    // $ANTLR start "rule__Component__Group__3"
    // InternalDasl.g:1834:1: rule__Component__Group__3 : rule__Component__Group__3__Impl rule__Component__Group__4 ;
    public final void rule__Component__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1838:1: ( rule__Component__Group__3__Impl rule__Component__Group__4 )
            // InternalDasl.g:1839:2: rule__Component__Group__3__Impl rule__Component__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Component__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__3"


    // $ANTLR start "rule__Component__Group__3__Impl"
    // InternalDasl.g:1846:1: rule__Component__Group__3__Impl : ( 'ref' ) ;
    public final void rule__Component__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1850:1: ( ( 'ref' ) )
            // InternalDasl.g:1851:1: ( 'ref' )
            {
            // InternalDasl.g:1851:1: ( 'ref' )
            // InternalDasl.g:1852:2: 'ref'
            {
             before(grammarAccess.getComponentAccess().getRefKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getRefKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__3__Impl"


    // $ANTLR start "rule__Component__Group__4"
    // InternalDasl.g:1861:1: rule__Component__Group__4 : rule__Component__Group__4__Impl rule__Component__Group__5 ;
    public final void rule__Component__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1865:1: ( rule__Component__Group__4__Impl rule__Component__Group__5 )
            // InternalDasl.g:1866:2: rule__Component__Group__4__Impl rule__Component__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__Component__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__4"


    // $ANTLR start "rule__Component__Group__4__Impl"
    // InternalDasl.g:1873:1: rule__Component__Group__4__Impl : ( ( rule__Component__RefAssignment_4 ) ) ;
    public final void rule__Component__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1877:1: ( ( ( rule__Component__RefAssignment_4 ) ) )
            // InternalDasl.g:1878:1: ( ( rule__Component__RefAssignment_4 ) )
            {
            // InternalDasl.g:1878:1: ( ( rule__Component__RefAssignment_4 ) )
            // InternalDasl.g:1879:2: ( rule__Component__RefAssignment_4 )
            {
             before(grammarAccess.getComponentAccess().getRefAssignment_4()); 
            // InternalDasl.g:1880:2: ( rule__Component__RefAssignment_4 )
            // InternalDasl.g:1880:3: rule__Component__RefAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Component__RefAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getRefAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__4__Impl"


    // $ANTLR start "rule__Component__Group__5"
    // InternalDasl.g:1888:1: rule__Component__Group__5 : rule__Component__Group__5__Impl rule__Component__Group__6 ;
    public final void rule__Component__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1892:1: ( rule__Component__Group__5__Impl rule__Component__Group__6 )
            // InternalDasl.g:1893:2: rule__Component__Group__5__Impl rule__Component__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Component__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__5"


    // $ANTLR start "rule__Component__Group__5__Impl"
    // InternalDasl.g:1900:1: rule__Component__Group__5__Impl : ( 'stereotype' ) ;
    public final void rule__Component__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1904:1: ( ( 'stereotype' ) )
            // InternalDasl.g:1905:1: ( 'stereotype' )
            {
            // InternalDasl.g:1905:1: ( 'stereotype' )
            // InternalDasl.g:1906:2: 'stereotype'
            {
             before(grammarAccess.getComponentAccess().getStereotypeKeyword_5()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getStereotypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__5__Impl"


    // $ANTLR start "rule__Component__Group__6"
    // InternalDasl.g:1915:1: rule__Component__Group__6 : rule__Component__Group__6__Impl rule__Component__Group__7 ;
    public final void rule__Component__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1919:1: ( rule__Component__Group__6__Impl rule__Component__Group__7 )
            // InternalDasl.g:1920:2: rule__Component__Group__6__Impl rule__Component__Group__7
            {
            pushFollow(FOLLOW_24);
            rule__Component__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__6"


    // $ANTLR start "rule__Component__Group__6__Impl"
    // InternalDasl.g:1927:1: rule__Component__Group__6__Impl : ( ( rule__Component__StereotypeAssignment_6 ) ) ;
    public final void rule__Component__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1931:1: ( ( ( rule__Component__StereotypeAssignment_6 ) ) )
            // InternalDasl.g:1932:1: ( ( rule__Component__StereotypeAssignment_6 ) )
            {
            // InternalDasl.g:1932:1: ( ( rule__Component__StereotypeAssignment_6 ) )
            // InternalDasl.g:1933:2: ( rule__Component__StereotypeAssignment_6 )
            {
             before(grammarAccess.getComponentAccess().getStereotypeAssignment_6()); 
            // InternalDasl.g:1934:2: ( rule__Component__StereotypeAssignment_6 )
            // InternalDasl.g:1934:3: rule__Component__StereotypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Component__StereotypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getStereotypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__6__Impl"


    // $ANTLR start "rule__Component__Group__7"
    // InternalDasl.g:1942:1: rule__Component__Group__7 : rule__Component__Group__7__Impl rule__Component__Group__8 ;
    public final void rule__Component__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1946:1: ( rule__Component__Group__7__Impl rule__Component__Group__8 )
            // InternalDasl.g:1947:2: rule__Component__Group__7__Impl rule__Component__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__Component__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__7"


    // $ANTLR start "rule__Component__Group__7__Impl"
    // InternalDasl.g:1954:1: rule__Component__Group__7__Impl : ( ( rule__Component__Group_7__0 )? ) ;
    public final void rule__Component__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1958:1: ( ( ( rule__Component__Group_7__0 )? ) )
            // InternalDasl.g:1959:1: ( ( rule__Component__Group_7__0 )? )
            {
            // InternalDasl.g:1959:1: ( ( rule__Component__Group_7__0 )? )
            // InternalDasl.g:1960:2: ( rule__Component__Group_7__0 )?
            {
             before(grammarAccess.getComponentAccess().getGroup_7()); 
            // InternalDasl.g:1961:2: ( rule__Component__Group_7__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==87) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDasl.g:1961:3: rule__Component__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Component__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComponentAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__7__Impl"


    // $ANTLR start "rule__Component__Group__8"
    // InternalDasl.g:1969:1: rule__Component__Group__8 : rule__Component__Group__8__Impl rule__Component__Group__9 ;
    public final void rule__Component__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1973:1: ( rule__Component__Group__8__Impl rule__Component__Group__9 )
            // InternalDasl.g:1974:2: rule__Component__Group__8__Impl rule__Component__Group__9
            {
            pushFollow(FOLLOW_7);
            rule__Component__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__8"


    // $ANTLR start "rule__Component__Group__8__Impl"
    // InternalDasl.g:1981:1: rule__Component__Group__8__Impl : ( 'desc' ) ;
    public final void rule__Component__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:1985:1: ( ( 'desc' ) )
            // InternalDasl.g:1986:1: ( 'desc' )
            {
            // InternalDasl.g:1986:1: ( 'desc' )
            // InternalDasl.g:1987:2: 'desc'
            {
             before(grammarAccess.getComponentAccess().getDescKeyword_8()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getDescKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__8__Impl"


    // $ANTLR start "rule__Component__Group__9"
    // InternalDasl.g:1996:1: rule__Component__Group__9 : rule__Component__Group__9__Impl rule__Component__Group__10 ;
    public final void rule__Component__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2000:1: ( rule__Component__Group__9__Impl rule__Component__Group__10 )
            // InternalDasl.g:2001:2: rule__Component__Group__9__Impl rule__Component__Group__10
            {
            pushFollow(FOLLOW_25);
            rule__Component__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__9"


    // $ANTLR start "rule__Component__Group__9__Impl"
    // InternalDasl.g:2008:1: rule__Component__Group__9__Impl : ( ( rule__Component__DescAssignment_9 ) ) ;
    public final void rule__Component__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2012:1: ( ( ( rule__Component__DescAssignment_9 ) ) )
            // InternalDasl.g:2013:1: ( ( rule__Component__DescAssignment_9 ) )
            {
            // InternalDasl.g:2013:1: ( ( rule__Component__DescAssignment_9 ) )
            // InternalDasl.g:2014:2: ( rule__Component__DescAssignment_9 )
            {
             before(grammarAccess.getComponentAccess().getDescAssignment_9()); 
            // InternalDasl.g:2015:2: ( rule__Component__DescAssignment_9 )
            // InternalDasl.g:2015:3: rule__Component__DescAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Component__DescAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getDescAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__9__Impl"


    // $ANTLR start "rule__Component__Group__10"
    // InternalDasl.g:2023:1: rule__Component__Group__10 : rule__Component__Group__10__Impl rule__Component__Group__11 ;
    public final void rule__Component__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2027:1: ( rule__Component__Group__10__Impl rule__Component__Group__11 )
            // InternalDasl.g:2028:2: rule__Component__Group__10__Impl rule__Component__Group__11
            {
            pushFollow(FOLLOW_7);
            rule__Component__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__10"


    // $ANTLR start "rule__Component__Group__10__Impl"
    // InternalDasl.g:2035:1: rule__Component__Group__10__Impl : ( 'version' ) ;
    public final void rule__Component__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2039:1: ( ( 'version' ) )
            // InternalDasl.g:2040:1: ( 'version' )
            {
            // InternalDasl.g:2040:1: ( 'version' )
            // InternalDasl.g:2041:2: 'version'
            {
             before(grammarAccess.getComponentAccess().getVersionKeyword_10()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getVersionKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__10__Impl"


    // $ANTLR start "rule__Component__Group__11"
    // InternalDasl.g:2050:1: rule__Component__Group__11 : rule__Component__Group__11__Impl rule__Component__Group__12 ;
    public final void rule__Component__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2054:1: ( rule__Component__Group__11__Impl rule__Component__Group__12 )
            // InternalDasl.g:2055:2: rule__Component__Group__11__Impl rule__Component__Group__12
            {
            pushFollow(FOLLOW_26);
            rule__Component__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__11"


    // $ANTLR start "rule__Component__Group__11__Impl"
    // InternalDasl.g:2062:1: rule__Component__Group__11__Impl : ( ( rule__Component__VersionAssignment_11 ) ) ;
    public final void rule__Component__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2066:1: ( ( ( rule__Component__VersionAssignment_11 ) ) )
            // InternalDasl.g:2067:1: ( ( rule__Component__VersionAssignment_11 ) )
            {
            // InternalDasl.g:2067:1: ( ( rule__Component__VersionAssignment_11 ) )
            // InternalDasl.g:2068:2: ( rule__Component__VersionAssignment_11 )
            {
             before(grammarAccess.getComponentAccess().getVersionAssignment_11()); 
            // InternalDasl.g:2069:2: ( rule__Component__VersionAssignment_11 )
            // InternalDasl.g:2069:3: rule__Component__VersionAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Component__VersionAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getVersionAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__11__Impl"


    // $ANTLR start "rule__Component__Group__12"
    // InternalDasl.g:2077:1: rule__Component__Group__12 : rule__Component__Group__12__Impl rule__Component__Group__13 ;
    public final void rule__Component__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2081:1: ( rule__Component__Group__12__Impl rule__Component__Group__13 )
            // InternalDasl.g:2082:2: rule__Component__Group__12__Impl rule__Component__Group__13
            {
            pushFollow(FOLLOW_27);
            rule__Component__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__12"


    // $ANTLR start "rule__Component__Group__12__Impl"
    // InternalDasl.g:2089:1: rule__Component__Group__12__Impl : ( 'assets' ) ;
    public final void rule__Component__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2093:1: ( ( 'assets' ) )
            // InternalDasl.g:2094:1: ( 'assets' )
            {
            // InternalDasl.g:2094:1: ( 'assets' )
            // InternalDasl.g:2095:2: 'assets'
            {
             before(grammarAccess.getComponentAccess().getAssetsKeyword_12()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getAssetsKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__12__Impl"


    // $ANTLR start "rule__Component__Group__13"
    // InternalDasl.g:2104:1: rule__Component__Group__13 : rule__Component__Group__13__Impl rule__Component__Group__14 ;
    public final void rule__Component__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2108:1: ( rule__Component__Group__13__Impl rule__Component__Group__14 )
            // InternalDasl.g:2109:2: rule__Component__Group__13__Impl rule__Component__Group__14
            {
            pushFollow(FOLLOW_27);
            rule__Component__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__13"


    // $ANTLR start "rule__Component__Group__13__Impl"
    // InternalDasl.g:2116:1: rule__Component__Group__13__Impl : ( ( rule__Component__AssetsAssignment_13 )* ) ;
    public final void rule__Component__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2120:1: ( ( ( rule__Component__AssetsAssignment_13 )* ) )
            // InternalDasl.g:2121:1: ( ( rule__Component__AssetsAssignment_13 )* )
            {
            // InternalDasl.g:2121:1: ( ( rule__Component__AssetsAssignment_13 )* )
            // InternalDasl.g:2122:2: ( rule__Component__AssetsAssignment_13 )*
            {
             before(grammarAccess.getComponentAccess().getAssetsAssignment_13()); 
            // InternalDasl.g:2123:2: ( rule__Component__AssetsAssignment_13 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDasl.g:2123:3: rule__Component__AssetsAssignment_13
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Component__AssetsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getComponentAccess().getAssetsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__13__Impl"


    // $ANTLR start "rule__Component__Group__14"
    // InternalDasl.g:2131:1: rule__Component__Group__14 : rule__Component__Group__14__Impl rule__Component__Group__15 ;
    public final void rule__Component__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2135:1: ( rule__Component__Group__14__Impl rule__Component__Group__15 )
            // InternalDasl.g:2136:2: rule__Component__Group__14__Impl rule__Component__Group__15
            {
            pushFollow(FOLLOW_27);
            rule__Component__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__14"


    // $ANTLR start "rule__Component__Group__14__Impl"
    // InternalDasl.g:2143:1: rule__Component__Group__14__Impl : ( ( rule__Component__ComponentsAssignment_14 )* ) ;
    public final void rule__Component__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2147:1: ( ( ( rule__Component__ComponentsAssignment_14 )* ) )
            // InternalDasl.g:2148:1: ( ( rule__Component__ComponentsAssignment_14 )* )
            {
            // InternalDasl.g:2148:1: ( ( rule__Component__ComponentsAssignment_14 )* )
            // InternalDasl.g:2149:2: ( rule__Component__ComponentsAssignment_14 )*
            {
             before(grammarAccess.getComponentAccess().getComponentsAssignment_14()); 
            // InternalDasl.g:2150:2: ( rule__Component__ComponentsAssignment_14 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==82) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDasl.g:2150:3: rule__Component__ComponentsAssignment_14
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__Component__ComponentsAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getComponentAccess().getComponentsAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__14__Impl"


    // $ANTLR start "rule__Component__Group__15"
    // InternalDasl.g:2158:1: rule__Component__Group__15 : rule__Component__Group__15__Impl ;
    public final void rule__Component__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2162:1: ( rule__Component__Group__15__Impl )
            // InternalDasl.g:2163:2: rule__Component__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__15"


    // $ANTLR start "rule__Component__Group__15__Impl"
    // InternalDasl.g:2169:1: rule__Component__Group__15__Impl : ( '}' ) ;
    public final void rule__Component__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2173:1: ( ( '}' ) )
            // InternalDasl.g:2174:1: ( '}' )
            {
            // InternalDasl.g:2174:1: ( '}' )
            // InternalDasl.g:2175:2: '}'
            {
             before(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_15()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group__15__Impl"


    // $ANTLR start "rule__Component__Group_7__0"
    // InternalDasl.g:2185:1: rule__Component__Group_7__0 : rule__Component__Group_7__0__Impl rule__Component__Group_7__1 ;
    public final void rule__Component__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2189:1: ( rule__Component__Group_7__0__Impl rule__Component__Group_7__1 )
            // InternalDasl.g:2190:2: rule__Component__Group_7__0__Impl rule__Component__Group_7__1
            {
            pushFollow(FOLLOW_7);
            rule__Component__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Component__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group_7__0"


    // $ANTLR start "rule__Component__Group_7__0__Impl"
    // InternalDasl.g:2197:1: rule__Component__Group_7__0__Impl : ( 'vendor' ) ;
    public final void rule__Component__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2201:1: ( ( 'vendor' ) )
            // InternalDasl.g:2202:1: ( 'vendor' )
            {
            // InternalDasl.g:2202:1: ( 'vendor' )
            // InternalDasl.g:2203:2: 'vendor'
            {
             before(grammarAccess.getComponentAccess().getVendorKeyword_7_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getVendorKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group_7__0__Impl"


    // $ANTLR start "rule__Component__Group_7__1"
    // InternalDasl.g:2212:1: rule__Component__Group_7__1 : rule__Component__Group_7__1__Impl ;
    public final void rule__Component__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2216:1: ( rule__Component__Group_7__1__Impl )
            // InternalDasl.g:2217:2: rule__Component__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Component__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group_7__1"


    // $ANTLR start "rule__Component__Group_7__1__Impl"
    // InternalDasl.g:2223:1: rule__Component__Group_7__1__Impl : ( ( rule__Component__VendorAssignment_7_1 ) ) ;
    public final void rule__Component__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2227:1: ( ( ( rule__Component__VendorAssignment_7_1 ) ) )
            // InternalDasl.g:2228:1: ( ( rule__Component__VendorAssignment_7_1 ) )
            {
            // InternalDasl.g:2228:1: ( ( rule__Component__VendorAssignment_7_1 ) )
            // InternalDasl.g:2229:2: ( rule__Component__VendorAssignment_7_1 )
            {
             before(grammarAccess.getComponentAccess().getVendorAssignment_7_1()); 
            // InternalDasl.g:2230:2: ( rule__Component__VendorAssignment_7_1 )
            // InternalDasl.g:2230:3: rule__Component__VendorAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Component__VendorAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentAccess().getVendorAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__Group_7__1__Impl"


    // $ANTLR start "rule__InformationAsset__Group__0"
    // InternalDasl.g:2239:1: rule__InformationAsset__Group__0 : rule__InformationAsset__Group__0__Impl rule__InformationAsset__Group__1 ;
    public final void rule__InformationAsset__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2243:1: ( rule__InformationAsset__Group__0__Impl rule__InformationAsset__Group__1 )
            // InternalDasl.g:2244:2: rule__InformationAsset__Group__0__Impl rule__InformationAsset__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__InformationAsset__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__0"


    // $ANTLR start "rule__InformationAsset__Group__0__Impl"
    // InternalDasl.g:2251:1: rule__InformationAsset__Group__0__Impl : ( 'informationasset' ) ;
    public final void rule__InformationAsset__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2255:1: ( ( 'informationasset' ) )
            // InternalDasl.g:2256:1: ( 'informationasset' )
            {
            // InternalDasl.g:2256:1: ( 'informationasset' )
            // InternalDasl.g:2257:2: 'informationasset'
            {
             before(grammarAccess.getInformationAssetAccess().getInformationassetKeyword_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getInformationassetKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__0__Impl"


    // $ANTLR start "rule__InformationAsset__Group__1"
    // InternalDasl.g:2266:1: rule__InformationAsset__Group__1 : rule__InformationAsset__Group__1__Impl rule__InformationAsset__Group__2 ;
    public final void rule__InformationAsset__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2270:1: ( rule__InformationAsset__Group__1__Impl rule__InformationAsset__Group__2 )
            // InternalDasl.g:2271:2: rule__InformationAsset__Group__1__Impl rule__InformationAsset__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__InformationAsset__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__1"


    // $ANTLR start "rule__InformationAsset__Group__1__Impl"
    // InternalDasl.g:2278:1: rule__InformationAsset__Group__1__Impl : ( ( rule__InformationAsset__NameAssignment_1 ) ) ;
    public final void rule__InformationAsset__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2282:1: ( ( ( rule__InformationAsset__NameAssignment_1 ) ) )
            // InternalDasl.g:2283:1: ( ( rule__InformationAsset__NameAssignment_1 ) )
            {
            // InternalDasl.g:2283:1: ( ( rule__InformationAsset__NameAssignment_1 ) )
            // InternalDasl.g:2284:2: ( rule__InformationAsset__NameAssignment_1 )
            {
             before(grammarAccess.getInformationAssetAccess().getNameAssignment_1()); 
            // InternalDasl.g:2285:2: ( rule__InformationAsset__NameAssignment_1 )
            // InternalDasl.g:2285:3: rule__InformationAsset__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__1__Impl"


    // $ANTLR start "rule__InformationAsset__Group__2"
    // InternalDasl.g:2293:1: rule__InformationAsset__Group__2 : rule__InformationAsset__Group__2__Impl rule__InformationAsset__Group__3 ;
    public final void rule__InformationAsset__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2297:1: ( rule__InformationAsset__Group__2__Impl rule__InformationAsset__Group__3 )
            // InternalDasl.g:2298:2: rule__InformationAsset__Group__2__Impl rule__InformationAsset__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__InformationAsset__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__2"


    // $ANTLR start "rule__InformationAsset__Group__2__Impl"
    // InternalDasl.g:2305:1: rule__InformationAsset__Group__2__Impl : ( '{' ) ;
    public final void rule__InformationAsset__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2309:1: ( ( '{' ) )
            // InternalDasl.g:2310:1: ( '{' )
            {
            // InternalDasl.g:2310:1: ( '{' )
            // InternalDasl.g:2311:2: '{'
            {
             before(grammarAccess.getInformationAssetAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__2__Impl"


    // $ANTLR start "rule__InformationAsset__Group__3"
    // InternalDasl.g:2320:1: rule__InformationAsset__Group__3 : rule__InformationAsset__Group__3__Impl rule__InformationAsset__Group__4 ;
    public final void rule__InformationAsset__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2324:1: ( rule__InformationAsset__Group__3__Impl rule__InformationAsset__Group__4 )
            // InternalDasl.g:2325:2: rule__InformationAsset__Group__3__Impl rule__InformationAsset__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__InformationAsset__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__3"


    // $ANTLR start "rule__InformationAsset__Group__3__Impl"
    // InternalDasl.g:2332:1: rule__InformationAsset__Group__3__Impl : ( 'ref' ) ;
    public final void rule__InformationAsset__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2336:1: ( ( 'ref' ) )
            // InternalDasl.g:2337:1: ( 'ref' )
            {
            // InternalDasl.g:2337:1: ( 'ref' )
            // InternalDasl.g:2338:2: 'ref'
            {
             before(grammarAccess.getInformationAssetAccess().getRefKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getRefKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__3__Impl"


    // $ANTLR start "rule__InformationAsset__Group__4"
    // InternalDasl.g:2347:1: rule__InformationAsset__Group__4 : rule__InformationAsset__Group__4__Impl rule__InformationAsset__Group__5 ;
    public final void rule__InformationAsset__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2351:1: ( rule__InformationAsset__Group__4__Impl rule__InformationAsset__Group__5 )
            // InternalDasl.g:2352:2: rule__InformationAsset__Group__4__Impl rule__InformationAsset__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__InformationAsset__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__4"


    // $ANTLR start "rule__InformationAsset__Group__4__Impl"
    // InternalDasl.g:2359:1: rule__InformationAsset__Group__4__Impl : ( ( rule__InformationAsset__RefAssignment_4 ) ) ;
    public final void rule__InformationAsset__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2363:1: ( ( ( rule__InformationAsset__RefAssignment_4 ) ) )
            // InternalDasl.g:2364:1: ( ( rule__InformationAsset__RefAssignment_4 ) )
            {
            // InternalDasl.g:2364:1: ( ( rule__InformationAsset__RefAssignment_4 ) )
            // InternalDasl.g:2365:2: ( rule__InformationAsset__RefAssignment_4 )
            {
             before(grammarAccess.getInformationAssetAccess().getRefAssignment_4()); 
            // InternalDasl.g:2366:2: ( rule__InformationAsset__RefAssignment_4 )
            // InternalDasl.g:2366:3: rule__InformationAsset__RefAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__RefAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getRefAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__4__Impl"


    // $ANTLR start "rule__InformationAsset__Group__5"
    // InternalDasl.g:2374:1: rule__InformationAsset__Group__5 : rule__InformationAsset__Group__5__Impl rule__InformationAsset__Group__6 ;
    public final void rule__InformationAsset__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2378:1: ( rule__InformationAsset__Group__5__Impl rule__InformationAsset__Group__6 )
            // InternalDasl.g:2379:2: rule__InformationAsset__Group__5__Impl rule__InformationAsset__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__InformationAsset__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__5"


    // $ANTLR start "rule__InformationAsset__Group__5__Impl"
    // InternalDasl.g:2386:1: rule__InformationAsset__Group__5__Impl : ( 'desc' ) ;
    public final void rule__InformationAsset__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2390:1: ( ( 'desc' ) )
            // InternalDasl.g:2391:1: ( 'desc' )
            {
            // InternalDasl.g:2391:1: ( 'desc' )
            // InternalDasl.g:2392:2: 'desc'
            {
             before(grammarAccess.getInformationAssetAccess().getDescKeyword_5()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getDescKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__5__Impl"


    // $ANTLR start "rule__InformationAsset__Group__6"
    // InternalDasl.g:2401:1: rule__InformationAsset__Group__6 : rule__InformationAsset__Group__6__Impl rule__InformationAsset__Group__7 ;
    public final void rule__InformationAsset__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2405:1: ( rule__InformationAsset__Group__6__Impl rule__InformationAsset__Group__7 )
            // InternalDasl.g:2406:2: rule__InformationAsset__Group__6__Impl rule__InformationAsset__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__InformationAsset__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__6"


    // $ANTLR start "rule__InformationAsset__Group__6__Impl"
    // InternalDasl.g:2413:1: rule__InformationAsset__Group__6__Impl : ( ( rule__InformationAsset__DescAssignment_6 ) ) ;
    public final void rule__InformationAsset__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2417:1: ( ( ( rule__InformationAsset__DescAssignment_6 ) ) )
            // InternalDasl.g:2418:1: ( ( rule__InformationAsset__DescAssignment_6 ) )
            {
            // InternalDasl.g:2418:1: ( ( rule__InformationAsset__DescAssignment_6 ) )
            // InternalDasl.g:2419:2: ( rule__InformationAsset__DescAssignment_6 )
            {
             before(grammarAccess.getInformationAssetAccess().getDescAssignment_6()); 
            // InternalDasl.g:2420:2: ( rule__InformationAsset__DescAssignment_6 )
            // InternalDasl.g:2420:3: rule__InformationAsset__DescAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__DescAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getDescAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__6__Impl"


    // $ANTLR start "rule__InformationAsset__Group__7"
    // InternalDasl.g:2428:1: rule__InformationAsset__Group__7 : rule__InformationAsset__Group__7__Impl rule__InformationAsset__Group__8 ;
    public final void rule__InformationAsset__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2432:1: ( rule__InformationAsset__Group__7__Impl rule__InformationAsset__Group__8 )
            // InternalDasl.g:2433:2: rule__InformationAsset__Group__7__Impl rule__InformationAsset__Group__8
            {
            pushFollow(FOLLOW_31);
            rule__InformationAsset__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__7"


    // $ANTLR start "rule__InformationAsset__Group__7__Impl"
    // InternalDasl.g:2440:1: rule__InformationAsset__Group__7__Impl : ( 'confidentiality' ) ;
    public final void rule__InformationAsset__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2444:1: ( ( 'confidentiality' ) )
            // InternalDasl.g:2445:1: ( 'confidentiality' )
            {
            // InternalDasl.g:2445:1: ( 'confidentiality' )
            // InternalDasl.g:2446:2: 'confidentiality'
            {
             before(grammarAccess.getInformationAssetAccess().getConfidentialityKeyword_7()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getConfidentialityKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__7__Impl"


    // $ANTLR start "rule__InformationAsset__Group__8"
    // InternalDasl.g:2455:1: rule__InformationAsset__Group__8 : rule__InformationAsset__Group__8__Impl rule__InformationAsset__Group__9 ;
    public final void rule__InformationAsset__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2459:1: ( rule__InformationAsset__Group__8__Impl rule__InformationAsset__Group__9 )
            // InternalDasl.g:2460:2: rule__InformationAsset__Group__8__Impl rule__InformationAsset__Group__9
            {
            pushFollow(FOLLOW_32);
            rule__InformationAsset__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__8"


    // $ANTLR start "rule__InformationAsset__Group__8__Impl"
    // InternalDasl.g:2467:1: rule__InformationAsset__Group__8__Impl : ( ( rule__InformationAsset__ConfidentialityAssignment_8 ) ) ;
    public final void rule__InformationAsset__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2471:1: ( ( ( rule__InformationAsset__ConfidentialityAssignment_8 ) ) )
            // InternalDasl.g:2472:1: ( ( rule__InformationAsset__ConfidentialityAssignment_8 ) )
            {
            // InternalDasl.g:2472:1: ( ( rule__InformationAsset__ConfidentialityAssignment_8 ) )
            // InternalDasl.g:2473:2: ( rule__InformationAsset__ConfidentialityAssignment_8 )
            {
             before(grammarAccess.getInformationAssetAccess().getConfidentialityAssignment_8()); 
            // InternalDasl.g:2474:2: ( rule__InformationAsset__ConfidentialityAssignment_8 )
            // InternalDasl.g:2474:3: rule__InformationAsset__ConfidentialityAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__ConfidentialityAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getConfidentialityAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__8__Impl"


    // $ANTLR start "rule__InformationAsset__Group__9"
    // InternalDasl.g:2482:1: rule__InformationAsset__Group__9 : rule__InformationAsset__Group__9__Impl rule__InformationAsset__Group__10 ;
    public final void rule__InformationAsset__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2486:1: ( rule__InformationAsset__Group__9__Impl rule__InformationAsset__Group__10 )
            // InternalDasl.g:2487:2: rule__InformationAsset__Group__9__Impl rule__InformationAsset__Group__10
            {
            pushFollow(FOLLOW_33);
            rule__InformationAsset__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__9"


    // $ANTLR start "rule__InformationAsset__Group__9__Impl"
    // InternalDasl.g:2494:1: rule__InformationAsset__Group__9__Impl : ( 'integrity' ) ;
    public final void rule__InformationAsset__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2498:1: ( ( 'integrity' ) )
            // InternalDasl.g:2499:1: ( 'integrity' )
            {
            // InternalDasl.g:2499:1: ( 'integrity' )
            // InternalDasl.g:2500:2: 'integrity'
            {
             before(grammarAccess.getInformationAssetAccess().getIntegrityKeyword_9()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getIntegrityKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__9__Impl"


    // $ANTLR start "rule__InformationAsset__Group__10"
    // InternalDasl.g:2509:1: rule__InformationAsset__Group__10 : rule__InformationAsset__Group__10__Impl rule__InformationAsset__Group__11 ;
    public final void rule__InformationAsset__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2513:1: ( rule__InformationAsset__Group__10__Impl rule__InformationAsset__Group__11 )
            // InternalDasl.g:2514:2: rule__InformationAsset__Group__10__Impl rule__InformationAsset__Group__11
            {
            pushFollow(FOLLOW_34);
            rule__InformationAsset__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__10"


    // $ANTLR start "rule__InformationAsset__Group__10__Impl"
    // InternalDasl.g:2521:1: rule__InformationAsset__Group__10__Impl : ( ( rule__InformationAsset__IntegrityAssignment_10 ) ) ;
    public final void rule__InformationAsset__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2525:1: ( ( ( rule__InformationAsset__IntegrityAssignment_10 ) ) )
            // InternalDasl.g:2526:1: ( ( rule__InformationAsset__IntegrityAssignment_10 ) )
            {
            // InternalDasl.g:2526:1: ( ( rule__InformationAsset__IntegrityAssignment_10 ) )
            // InternalDasl.g:2527:2: ( rule__InformationAsset__IntegrityAssignment_10 )
            {
             before(grammarAccess.getInformationAssetAccess().getIntegrityAssignment_10()); 
            // InternalDasl.g:2528:2: ( rule__InformationAsset__IntegrityAssignment_10 )
            // InternalDasl.g:2528:3: rule__InformationAsset__IntegrityAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__IntegrityAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getIntegrityAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__10__Impl"


    // $ANTLR start "rule__InformationAsset__Group__11"
    // InternalDasl.g:2536:1: rule__InformationAsset__Group__11 : rule__InformationAsset__Group__11__Impl rule__InformationAsset__Group__12 ;
    public final void rule__InformationAsset__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2540:1: ( rule__InformationAsset__Group__11__Impl rule__InformationAsset__Group__12 )
            // InternalDasl.g:2541:2: rule__InformationAsset__Group__11__Impl rule__InformationAsset__Group__12
            {
            pushFollow(FOLLOW_35);
            rule__InformationAsset__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__11"


    // $ANTLR start "rule__InformationAsset__Group__11__Impl"
    // InternalDasl.g:2548:1: rule__InformationAsset__Group__11__Impl : ( 'availability' ) ;
    public final void rule__InformationAsset__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2552:1: ( ( 'availability' ) )
            // InternalDasl.g:2553:1: ( 'availability' )
            {
            // InternalDasl.g:2553:1: ( 'availability' )
            // InternalDasl.g:2554:2: 'availability'
            {
             before(grammarAccess.getInformationAssetAccess().getAvailabilityKeyword_11()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getAvailabilityKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__11__Impl"


    // $ANTLR start "rule__InformationAsset__Group__12"
    // InternalDasl.g:2563:1: rule__InformationAsset__Group__12 : rule__InformationAsset__Group__12__Impl rule__InformationAsset__Group__13 ;
    public final void rule__InformationAsset__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2567:1: ( rule__InformationAsset__Group__12__Impl rule__InformationAsset__Group__13 )
            // InternalDasl.g:2568:2: rule__InformationAsset__Group__12__Impl rule__InformationAsset__Group__13
            {
            pushFollow(FOLLOW_36);
            rule__InformationAsset__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__12"


    // $ANTLR start "rule__InformationAsset__Group__12__Impl"
    // InternalDasl.g:2575:1: rule__InformationAsset__Group__12__Impl : ( ( rule__InformationAsset__AvailabilityAssignment_12 ) ) ;
    public final void rule__InformationAsset__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2579:1: ( ( ( rule__InformationAsset__AvailabilityAssignment_12 ) ) )
            // InternalDasl.g:2580:1: ( ( rule__InformationAsset__AvailabilityAssignment_12 ) )
            {
            // InternalDasl.g:2580:1: ( ( rule__InformationAsset__AvailabilityAssignment_12 ) )
            // InternalDasl.g:2581:2: ( rule__InformationAsset__AvailabilityAssignment_12 )
            {
             before(grammarAccess.getInformationAssetAccess().getAvailabilityAssignment_12()); 
            // InternalDasl.g:2582:2: ( rule__InformationAsset__AvailabilityAssignment_12 )
            // InternalDasl.g:2582:3: rule__InformationAsset__AvailabilityAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__AvailabilityAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getInformationAssetAccess().getAvailabilityAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__12__Impl"


    // $ANTLR start "rule__InformationAsset__Group__13"
    // InternalDasl.g:2590:1: rule__InformationAsset__Group__13 : rule__InformationAsset__Group__13__Impl ;
    public final void rule__InformationAsset__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2594:1: ( rule__InformationAsset__Group__13__Impl )
            // InternalDasl.g:2595:2: rule__InformationAsset__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InformationAsset__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__13"


    // $ANTLR start "rule__InformationAsset__Group__13__Impl"
    // InternalDasl.g:2601:1: rule__InformationAsset__Group__13__Impl : ( '}' ) ;
    public final void rule__InformationAsset__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2605:1: ( ( '}' ) )
            // InternalDasl.g:2606:1: ( '}' )
            {
            // InternalDasl.g:2606:1: ( '}' )
            // InternalDasl.g:2607:2: '}'
            {
             before(grammarAccess.getInformationAssetAccess().getRightCurlyBracketKeyword_13()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__Group__13__Impl"


    // $ANTLR start "rule__Flow__Group__0"
    // InternalDasl.g:2617:1: rule__Flow__Group__0 : rule__Flow__Group__0__Impl rule__Flow__Group__1 ;
    public final void rule__Flow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2621:1: ( rule__Flow__Group__0__Impl rule__Flow__Group__1 )
            // InternalDasl.g:2622:2: rule__Flow__Group__0__Impl rule__Flow__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Flow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__0"


    // $ANTLR start "rule__Flow__Group__0__Impl"
    // InternalDasl.g:2629:1: rule__Flow__Group__0__Impl : ( 'flow' ) ;
    public final void rule__Flow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2633:1: ( ( 'flow' ) )
            // InternalDasl.g:2634:1: ( 'flow' )
            {
            // InternalDasl.g:2634:1: ( 'flow' )
            // InternalDasl.g:2635:2: 'flow'
            {
             before(grammarAccess.getFlowAccess().getFlowKeyword_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getFlowKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__0__Impl"


    // $ANTLR start "rule__Flow__Group__1"
    // InternalDasl.g:2644:1: rule__Flow__Group__1 : rule__Flow__Group__1__Impl rule__Flow__Group__2 ;
    public final void rule__Flow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2648:1: ( rule__Flow__Group__1__Impl rule__Flow__Group__2 )
            // InternalDasl.g:2649:2: rule__Flow__Group__1__Impl rule__Flow__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Flow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__1"


    // $ANTLR start "rule__Flow__Group__1__Impl"
    // InternalDasl.g:2656:1: rule__Flow__Group__1__Impl : ( ( rule__Flow__NameAssignment_1 ) ) ;
    public final void rule__Flow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2660:1: ( ( ( rule__Flow__NameAssignment_1 ) ) )
            // InternalDasl.g:2661:1: ( ( rule__Flow__NameAssignment_1 ) )
            {
            // InternalDasl.g:2661:1: ( ( rule__Flow__NameAssignment_1 ) )
            // InternalDasl.g:2662:2: ( rule__Flow__NameAssignment_1 )
            {
             before(grammarAccess.getFlowAccess().getNameAssignment_1()); 
            // InternalDasl.g:2663:2: ( rule__Flow__NameAssignment_1 )
            // InternalDasl.g:2663:3: rule__Flow__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__1__Impl"


    // $ANTLR start "rule__Flow__Group__2"
    // InternalDasl.g:2671:1: rule__Flow__Group__2 : rule__Flow__Group__2__Impl rule__Flow__Group__3 ;
    public final void rule__Flow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2675:1: ( rule__Flow__Group__2__Impl rule__Flow__Group__3 )
            // InternalDasl.g:2676:2: rule__Flow__Group__2__Impl rule__Flow__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__Flow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__2"


    // $ANTLR start "rule__Flow__Group__2__Impl"
    // InternalDasl.g:2683:1: rule__Flow__Group__2__Impl : ( '{' ) ;
    public final void rule__Flow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2687:1: ( ( '{' ) )
            // InternalDasl.g:2688:1: ( '{' )
            {
            // InternalDasl.g:2688:1: ( '{' )
            // InternalDasl.g:2689:2: '{'
            {
             before(grammarAccess.getFlowAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__2__Impl"


    // $ANTLR start "rule__Flow__Group__3"
    // InternalDasl.g:2698:1: rule__Flow__Group__3 : rule__Flow__Group__3__Impl rule__Flow__Group__4 ;
    public final void rule__Flow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2702:1: ( rule__Flow__Group__3__Impl rule__Flow__Group__4 )
            // InternalDasl.g:2703:2: rule__Flow__Group__3__Impl rule__Flow__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Flow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__3"


    // $ANTLR start "rule__Flow__Group__3__Impl"
    // InternalDasl.g:2710:1: rule__Flow__Group__3__Impl : ( 'from' ) ;
    public final void rule__Flow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2714:1: ( ( 'from' ) )
            // InternalDasl.g:2715:1: ( 'from' )
            {
            // InternalDasl.g:2715:1: ( 'from' )
            // InternalDasl.g:2716:2: 'from'
            {
             before(grammarAccess.getFlowAccess().getFromKeyword_3()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getFromKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__3__Impl"


    // $ANTLR start "rule__Flow__Group__4"
    // InternalDasl.g:2725:1: rule__Flow__Group__4 : rule__Flow__Group__4__Impl rule__Flow__Group__5 ;
    public final void rule__Flow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2729:1: ( rule__Flow__Group__4__Impl rule__Flow__Group__5 )
            // InternalDasl.g:2730:2: rule__Flow__Group__4__Impl rule__Flow__Group__5
            {
            pushFollow(FOLLOW_38);
            rule__Flow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__4"


    // $ANTLR start "rule__Flow__Group__4__Impl"
    // InternalDasl.g:2737:1: rule__Flow__Group__4__Impl : ( ( rule__Flow__FromAssignment_4 ) ) ;
    public final void rule__Flow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2741:1: ( ( ( rule__Flow__FromAssignment_4 ) ) )
            // InternalDasl.g:2742:1: ( ( rule__Flow__FromAssignment_4 ) )
            {
            // InternalDasl.g:2742:1: ( ( rule__Flow__FromAssignment_4 ) )
            // InternalDasl.g:2743:2: ( rule__Flow__FromAssignment_4 )
            {
             before(grammarAccess.getFlowAccess().getFromAssignment_4()); 
            // InternalDasl.g:2744:2: ( rule__Flow__FromAssignment_4 )
            // InternalDasl.g:2744:3: rule__Flow__FromAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Flow__FromAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getFromAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__4__Impl"


    // $ANTLR start "rule__Flow__Group__5"
    // InternalDasl.g:2752:1: rule__Flow__Group__5 : rule__Flow__Group__5__Impl rule__Flow__Group__6 ;
    public final void rule__Flow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2756:1: ( rule__Flow__Group__5__Impl rule__Flow__Group__6 )
            // InternalDasl.g:2757:2: rule__Flow__Group__5__Impl rule__Flow__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Flow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__5"


    // $ANTLR start "rule__Flow__Group__5__Impl"
    // InternalDasl.g:2764:1: rule__Flow__Group__5__Impl : ( 'to' ) ;
    public final void rule__Flow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2768:1: ( ( 'to' ) )
            // InternalDasl.g:2769:1: ( 'to' )
            {
            // InternalDasl.g:2769:1: ( 'to' )
            // InternalDasl.g:2770:2: 'to'
            {
             before(grammarAccess.getFlowAccess().getToKeyword_5()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getToKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__5__Impl"


    // $ANTLR start "rule__Flow__Group__6"
    // InternalDasl.g:2779:1: rule__Flow__Group__6 : rule__Flow__Group__6__Impl rule__Flow__Group__7 ;
    public final void rule__Flow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2783:1: ( rule__Flow__Group__6__Impl rule__Flow__Group__7 )
            // InternalDasl.g:2784:2: rule__Flow__Group__6__Impl rule__Flow__Group__7
            {
            pushFollow(FOLLOW_39);
            rule__Flow__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__6"


    // $ANTLR start "rule__Flow__Group__6__Impl"
    // InternalDasl.g:2791:1: rule__Flow__Group__6__Impl : ( ( rule__Flow__ToAssignment_6 ) ) ;
    public final void rule__Flow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2795:1: ( ( ( rule__Flow__ToAssignment_6 ) ) )
            // InternalDasl.g:2796:1: ( ( rule__Flow__ToAssignment_6 ) )
            {
            // InternalDasl.g:2796:1: ( ( rule__Flow__ToAssignment_6 ) )
            // InternalDasl.g:2797:2: ( rule__Flow__ToAssignment_6 )
            {
             before(grammarAccess.getFlowAccess().getToAssignment_6()); 
            // InternalDasl.g:2798:2: ( rule__Flow__ToAssignment_6 )
            // InternalDasl.g:2798:3: rule__Flow__ToAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Flow__ToAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getToAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__6__Impl"


    // $ANTLR start "rule__Flow__Group__7"
    // InternalDasl.g:2806:1: rule__Flow__Group__7 : rule__Flow__Group__7__Impl rule__Flow__Group__8 ;
    public final void rule__Flow__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2810:1: ( rule__Flow__Group__7__Impl rule__Flow__Group__8 )
            // InternalDasl.g:2811:2: rule__Flow__Group__7__Impl rule__Flow__Group__8
            {
            pushFollow(FOLLOW_40);
            rule__Flow__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__7"


    // $ANTLR start "rule__Flow__Group__7__Impl"
    // InternalDasl.g:2818:1: rule__Flow__Group__7__Impl : ( 'informationassets' ) ;
    public final void rule__Flow__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2822:1: ( ( 'informationassets' ) )
            // InternalDasl.g:2823:1: ( 'informationassets' )
            {
            // InternalDasl.g:2823:1: ( 'informationassets' )
            // InternalDasl.g:2824:2: 'informationassets'
            {
             before(grammarAccess.getFlowAccess().getInformationassetsKeyword_7()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getInformationassetsKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__7__Impl"


    // $ANTLR start "rule__Flow__Group__8"
    // InternalDasl.g:2833:1: rule__Flow__Group__8 : rule__Flow__Group__8__Impl rule__Flow__Group__9 ;
    public final void rule__Flow__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2837:1: ( rule__Flow__Group__8__Impl rule__Flow__Group__9 )
            // InternalDasl.g:2838:2: rule__Flow__Group__8__Impl rule__Flow__Group__9
            {
            pushFollow(FOLLOW_40);
            rule__Flow__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__8"


    // $ANTLR start "rule__Flow__Group__8__Impl"
    // InternalDasl.g:2845:1: rule__Flow__Group__8__Impl : ( ( rule__Flow__AssetsAssignment_8 )* ) ;
    public final void rule__Flow__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2849:1: ( ( ( rule__Flow__AssetsAssignment_8 )* ) )
            // InternalDasl.g:2850:1: ( ( rule__Flow__AssetsAssignment_8 )* )
            {
            // InternalDasl.g:2850:1: ( ( rule__Flow__AssetsAssignment_8 )* )
            // InternalDasl.g:2851:2: ( rule__Flow__AssetsAssignment_8 )*
            {
             before(grammarAccess.getFlowAccess().getAssetsAssignment_8()); 
            // InternalDasl.g:2852:2: ( rule__Flow__AssetsAssignment_8 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDasl.g:2852:3: rule__Flow__AssetsAssignment_8
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Flow__AssetsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getFlowAccess().getAssetsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__8__Impl"


    // $ANTLR start "rule__Flow__Group__9"
    // InternalDasl.g:2860:1: rule__Flow__Group__9 : rule__Flow__Group__9__Impl rule__Flow__Group__10 ;
    public final void rule__Flow__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2864:1: ( rule__Flow__Group__9__Impl rule__Flow__Group__10 )
            // InternalDasl.g:2865:2: rule__Flow__Group__9__Impl rule__Flow__Group__10
            {
            pushFollow(FOLLOW_22);
            rule__Flow__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__9"


    // $ANTLR start "rule__Flow__Group__9__Impl"
    // InternalDasl.g:2872:1: rule__Flow__Group__9__Impl : ( 'controls' ) ;
    public final void rule__Flow__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2876:1: ( ( 'controls' ) )
            // InternalDasl.g:2877:1: ( 'controls' )
            {
            // InternalDasl.g:2877:1: ( 'controls' )
            // InternalDasl.g:2878:2: 'controls'
            {
             before(grammarAccess.getFlowAccess().getControlsKeyword_9()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getControlsKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__9__Impl"


    // $ANTLR start "rule__Flow__Group__10"
    // InternalDasl.g:2887:1: rule__Flow__Group__10 : rule__Flow__Group__10__Impl rule__Flow__Group__11 ;
    public final void rule__Flow__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2891:1: ( rule__Flow__Group__10__Impl rule__Flow__Group__11 )
            // InternalDasl.g:2892:2: rule__Flow__Group__10__Impl rule__Flow__Group__11
            {
            pushFollow(FOLLOW_22);
            rule__Flow__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__10"


    // $ANTLR start "rule__Flow__Group__10__Impl"
    // InternalDasl.g:2899:1: rule__Flow__Group__10__Impl : ( ( rule__Flow__ControlsAssignment_10 )* ) ;
    public final void rule__Flow__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2903:1: ( ( ( rule__Flow__ControlsAssignment_10 )* ) )
            // InternalDasl.g:2904:1: ( ( rule__Flow__ControlsAssignment_10 )* )
            {
            // InternalDasl.g:2904:1: ( ( rule__Flow__ControlsAssignment_10 )* )
            // InternalDasl.g:2905:2: ( rule__Flow__ControlsAssignment_10 )*
            {
             before(grammarAccess.getFlowAccess().getControlsAssignment_10()); 
            // InternalDasl.g:2906:2: ( rule__Flow__ControlsAssignment_10 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDasl.g:2906:3: rule__Flow__ControlsAssignment_10
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Flow__ControlsAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getFlowAccess().getControlsAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__10__Impl"


    // $ANTLR start "rule__Flow__Group__11"
    // InternalDasl.g:2914:1: rule__Flow__Group__11 : rule__Flow__Group__11__Impl ;
    public final void rule__Flow__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2918:1: ( rule__Flow__Group__11__Impl )
            // InternalDasl.g:2919:2: rule__Flow__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__11"


    // $ANTLR start "rule__Flow__Group__11__Impl"
    // InternalDasl.g:2925:1: rule__Flow__Group__11__Impl : ( '}' ) ;
    public final void rule__Flow__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2929:1: ( ( '}' ) )
            // InternalDasl.g:2930:1: ( '}' )
            {
            // InternalDasl.g:2930:1: ( '}' )
            // InternalDasl.g:2931:2: '}'
            {
             before(grammarAccess.getFlowAccess().getRightCurlyBracketKeyword_11()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__11__Impl"


    // $ANTLR start "rule__Control__Group__0"
    // InternalDasl.g:2941:1: rule__Control__Group__0 : rule__Control__Group__0__Impl rule__Control__Group__1 ;
    public final void rule__Control__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2945:1: ( rule__Control__Group__0__Impl rule__Control__Group__1 )
            // InternalDasl.g:2946:2: rule__Control__Group__0__Impl rule__Control__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Control__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__0"


    // $ANTLR start "rule__Control__Group__0__Impl"
    // InternalDasl.g:2953:1: rule__Control__Group__0__Impl : ( 'control' ) ;
    public final void rule__Control__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2957:1: ( ( 'control' ) )
            // InternalDasl.g:2958:1: ( 'control' )
            {
            // InternalDasl.g:2958:1: ( 'control' )
            // InternalDasl.g:2959:2: 'control'
            {
             before(grammarAccess.getControlAccess().getControlKeyword_0()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getControlKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__0__Impl"


    // $ANTLR start "rule__Control__Group__1"
    // InternalDasl.g:2968:1: rule__Control__Group__1 : rule__Control__Group__1__Impl rule__Control__Group__2 ;
    public final void rule__Control__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2972:1: ( rule__Control__Group__1__Impl rule__Control__Group__2 )
            // InternalDasl.g:2973:2: rule__Control__Group__1__Impl rule__Control__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Control__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__1"


    // $ANTLR start "rule__Control__Group__1__Impl"
    // InternalDasl.g:2980:1: rule__Control__Group__1__Impl : ( ( rule__Control__NameAssignment_1 ) ) ;
    public final void rule__Control__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2984:1: ( ( ( rule__Control__NameAssignment_1 ) ) )
            // InternalDasl.g:2985:1: ( ( rule__Control__NameAssignment_1 ) )
            {
            // InternalDasl.g:2985:1: ( ( rule__Control__NameAssignment_1 ) )
            // InternalDasl.g:2986:2: ( rule__Control__NameAssignment_1 )
            {
             before(grammarAccess.getControlAccess().getNameAssignment_1()); 
            // InternalDasl.g:2987:2: ( rule__Control__NameAssignment_1 )
            // InternalDasl.g:2987:3: rule__Control__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Control__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getControlAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__1__Impl"


    // $ANTLR start "rule__Control__Group__2"
    // InternalDasl.g:2995:1: rule__Control__Group__2 : rule__Control__Group__2__Impl rule__Control__Group__3 ;
    public final void rule__Control__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:2999:1: ( rule__Control__Group__2__Impl rule__Control__Group__3 )
            // InternalDasl.g:3000:2: rule__Control__Group__2__Impl rule__Control__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Control__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__2"


    // $ANTLR start "rule__Control__Group__2__Impl"
    // InternalDasl.g:3007:1: rule__Control__Group__2__Impl : ( '{' ) ;
    public final void rule__Control__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3011:1: ( ( '{' ) )
            // InternalDasl.g:3012:1: ( '{' )
            {
            // InternalDasl.g:3012:1: ( '{' )
            // InternalDasl.g:3013:2: '{'
            {
             before(grammarAccess.getControlAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__2__Impl"


    // $ANTLR start "rule__Control__Group__3"
    // InternalDasl.g:3022:1: rule__Control__Group__3 : rule__Control__Group__3__Impl rule__Control__Group__4 ;
    public final void rule__Control__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3026:1: ( rule__Control__Group__3__Impl rule__Control__Group__4 )
            // InternalDasl.g:3027:2: rule__Control__Group__3__Impl rule__Control__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Control__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__3"


    // $ANTLR start "rule__Control__Group__3__Impl"
    // InternalDasl.g:3034:1: rule__Control__Group__3__Impl : ( 'ref' ) ;
    public final void rule__Control__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3038:1: ( ( 'ref' ) )
            // InternalDasl.g:3039:1: ( 'ref' )
            {
            // InternalDasl.g:3039:1: ( 'ref' )
            // InternalDasl.g:3040:2: 'ref'
            {
             before(grammarAccess.getControlAccess().getRefKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getRefKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__3__Impl"


    // $ANTLR start "rule__Control__Group__4"
    // InternalDasl.g:3049:1: rule__Control__Group__4 : rule__Control__Group__4__Impl rule__Control__Group__5 ;
    public final void rule__Control__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3053:1: ( rule__Control__Group__4__Impl rule__Control__Group__5 )
            // InternalDasl.g:3054:2: rule__Control__Group__4__Impl rule__Control__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__Control__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__4"


    // $ANTLR start "rule__Control__Group__4__Impl"
    // InternalDasl.g:3061:1: rule__Control__Group__4__Impl : ( ( rule__Control__RefAssignment_4 ) ) ;
    public final void rule__Control__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3065:1: ( ( ( rule__Control__RefAssignment_4 ) ) )
            // InternalDasl.g:3066:1: ( ( rule__Control__RefAssignment_4 ) )
            {
            // InternalDasl.g:3066:1: ( ( rule__Control__RefAssignment_4 ) )
            // InternalDasl.g:3067:2: ( rule__Control__RefAssignment_4 )
            {
             before(grammarAccess.getControlAccess().getRefAssignment_4()); 
            // InternalDasl.g:3068:2: ( rule__Control__RefAssignment_4 )
            // InternalDasl.g:3068:3: rule__Control__RefAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Control__RefAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getControlAccess().getRefAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__4__Impl"


    // $ANTLR start "rule__Control__Group__5"
    // InternalDasl.g:3076:1: rule__Control__Group__5 : rule__Control__Group__5__Impl rule__Control__Group__6 ;
    public final void rule__Control__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3080:1: ( rule__Control__Group__5__Impl rule__Control__Group__6 )
            // InternalDasl.g:3081:2: rule__Control__Group__5__Impl rule__Control__Group__6
            {
            pushFollow(FOLLOW_41);
            rule__Control__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__5"


    // $ANTLR start "rule__Control__Group__5__Impl"
    // InternalDasl.g:3088:1: rule__Control__Group__5__Impl : ( 'type' ) ;
    public final void rule__Control__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3092:1: ( ( 'type' ) )
            // InternalDasl.g:3093:1: ( 'type' )
            {
            // InternalDasl.g:3093:1: ( 'type' )
            // InternalDasl.g:3094:2: 'type'
            {
             before(grammarAccess.getControlAccess().getTypeKeyword_5()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getTypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__5__Impl"


    // $ANTLR start "rule__Control__Group__6"
    // InternalDasl.g:3103:1: rule__Control__Group__6 : rule__Control__Group__6__Impl rule__Control__Group__7 ;
    public final void rule__Control__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3107:1: ( rule__Control__Group__6__Impl rule__Control__Group__7 )
            // InternalDasl.g:3108:2: rule__Control__Group__6__Impl rule__Control__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__Control__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__6"


    // $ANTLR start "rule__Control__Group__6__Impl"
    // InternalDasl.g:3115:1: rule__Control__Group__6__Impl : ( ( rule__Control__AreaAssignment_6 ) ) ;
    public final void rule__Control__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3119:1: ( ( ( rule__Control__AreaAssignment_6 ) ) )
            // InternalDasl.g:3120:1: ( ( rule__Control__AreaAssignment_6 ) )
            {
            // InternalDasl.g:3120:1: ( ( rule__Control__AreaAssignment_6 ) )
            // InternalDasl.g:3121:2: ( rule__Control__AreaAssignment_6 )
            {
             before(grammarAccess.getControlAccess().getAreaAssignment_6()); 
            // InternalDasl.g:3122:2: ( rule__Control__AreaAssignment_6 )
            // InternalDasl.g:3122:3: rule__Control__AreaAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Control__AreaAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getControlAccess().getAreaAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__6__Impl"


    // $ANTLR start "rule__Control__Group__7"
    // InternalDasl.g:3130:1: rule__Control__Group__7 : rule__Control__Group__7__Impl rule__Control__Group__8 ;
    public final void rule__Control__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3134:1: ( rule__Control__Group__7__Impl rule__Control__Group__8 )
            // InternalDasl.g:3135:2: rule__Control__Group__7__Impl rule__Control__Group__8
            {
            pushFollow(FOLLOW_7);
            rule__Control__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__7"


    // $ANTLR start "rule__Control__Group__7__Impl"
    // InternalDasl.g:3142:1: rule__Control__Group__7__Impl : ( 'implementation' ) ;
    public final void rule__Control__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3146:1: ( ( 'implementation' ) )
            // InternalDasl.g:3147:1: ( 'implementation' )
            {
            // InternalDasl.g:3147:1: ( 'implementation' )
            // InternalDasl.g:3148:2: 'implementation'
            {
             before(grammarAccess.getControlAccess().getImplementationKeyword_7()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getImplementationKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__7__Impl"


    // $ANTLR start "rule__Control__Group__8"
    // InternalDasl.g:3157:1: rule__Control__Group__8 : rule__Control__Group__8__Impl rule__Control__Group__9 ;
    public final void rule__Control__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3161:1: ( rule__Control__Group__8__Impl rule__Control__Group__9 )
            // InternalDasl.g:3162:2: rule__Control__Group__8__Impl rule__Control__Group__9
            {
            pushFollow(FOLLOW_36);
            rule__Control__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Control__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__8"


    // $ANTLR start "rule__Control__Group__8__Impl"
    // InternalDasl.g:3169:1: rule__Control__Group__8__Impl : ( ( rule__Control__ImplementationAssignment_8 ) ) ;
    public final void rule__Control__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3173:1: ( ( ( rule__Control__ImplementationAssignment_8 ) ) )
            // InternalDasl.g:3174:1: ( ( rule__Control__ImplementationAssignment_8 ) )
            {
            // InternalDasl.g:3174:1: ( ( rule__Control__ImplementationAssignment_8 ) )
            // InternalDasl.g:3175:2: ( rule__Control__ImplementationAssignment_8 )
            {
             before(grammarAccess.getControlAccess().getImplementationAssignment_8()); 
            // InternalDasl.g:3176:2: ( rule__Control__ImplementationAssignment_8 )
            // InternalDasl.g:3176:3: rule__Control__ImplementationAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Control__ImplementationAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getControlAccess().getImplementationAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__8__Impl"


    // $ANTLR start "rule__Control__Group__9"
    // InternalDasl.g:3184:1: rule__Control__Group__9 : rule__Control__Group__9__Impl ;
    public final void rule__Control__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3188:1: ( rule__Control__Group__9__Impl )
            // InternalDasl.g:3189:2: rule__Control__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Control__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__9"


    // $ANTLR start "rule__Control__Group__9__Impl"
    // InternalDasl.g:3195:1: rule__Control__Group__9__Impl : ( '}' ) ;
    public final void rule__Control__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3199:1: ( ( '}' ) )
            // InternalDasl.g:3200:1: ( '}' )
            {
            // InternalDasl.g:3200:1: ( '}' )
            // InternalDasl.g:3201:2: '}'
            {
             before(grammarAccess.getControlAccess().getRightCurlyBracketKeyword_9()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__Group__9__Impl"


    // $ANTLR start "rule__SecurityModel__ElementsAssignment"
    // InternalDasl.g:3211:1: rule__SecurityModel__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__SecurityModel__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3215:1: ( ( ruleAbstractElement ) )
            // InternalDasl.g:3216:2: ( ruleAbstractElement )
            {
            // InternalDasl.g:3216:2: ( ruleAbstractElement )
            // InternalDasl.g:3217:3: ruleAbstractElement
            {
             before(grammarAccess.getSecurityModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getSecurityModelAccess().getElementsAbstractElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SecurityModel__ElementsAssignment"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // InternalDasl.g:3226:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3230:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3231:2: ( RULE_STRING )
            {
            // InternalDasl.g:3231:2: ( RULE_STRING )
            // InternalDasl.g:3232:3: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__Zone__NameAssignment_1"
    // InternalDasl.g:3241:1: rule__Zone__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Zone__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3245:1: ( ( RULE_ID ) )
            // InternalDasl.g:3246:2: ( RULE_ID )
            {
            // InternalDasl.g:3246:2: ( RULE_ID )
            // InternalDasl.g:3247:3: RULE_ID
            {
             before(grammarAccess.getZoneAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__NameAssignment_1"


    // $ANTLR start "rule__Zone__TrustAssignment_4"
    // InternalDasl.g:3256:1: rule__Zone__TrustAssignment_4 : ( RULE_INT ) ;
    public final void rule__Zone__TrustAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3260:1: ( ( RULE_INT ) )
            // InternalDasl.g:3261:2: ( RULE_INT )
            {
            // InternalDasl.g:3261:2: ( RULE_INT )
            // InternalDasl.g:3262:3: RULE_INT
            {
             before(grammarAccess.getZoneAccess().getTrustINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getTrustINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__TrustAssignment_4"


    // $ANTLR start "rule__Zone__IngressZonesAssignment_6"
    // InternalDasl.g:3271:1: rule__Zone__IngressZonesAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__Zone__IngressZonesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3275:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3276:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3276:2: ( ( RULE_ID ) )
            // InternalDasl.g:3277:3: ( RULE_ID )
            {
             before(grammarAccess.getZoneAccess().getIngressZonesZoneCrossReference_6_0()); 
            // InternalDasl.g:3278:3: ( RULE_ID )
            // InternalDasl.g:3279:4: RULE_ID
            {
             before(grammarAccess.getZoneAccess().getIngressZonesZoneIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getIngressZonesZoneIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getZoneAccess().getIngressZonesZoneCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__IngressZonesAssignment_6"


    // $ANTLR start "rule__Zone__EgressZonesAssignment_8"
    // InternalDasl.g:3290:1: rule__Zone__EgressZonesAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__Zone__EgressZonesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3294:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3295:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3295:2: ( ( RULE_ID ) )
            // InternalDasl.g:3296:3: ( RULE_ID )
            {
             before(grammarAccess.getZoneAccess().getEgressZonesZoneCrossReference_8_0()); 
            // InternalDasl.g:3297:3: ( RULE_ID )
            // InternalDasl.g:3298:4: RULE_ID
            {
             before(grammarAccess.getZoneAccess().getEgressZonesZoneIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getEgressZonesZoneIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getZoneAccess().getEgressZonesZoneCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__EgressZonesAssignment_8"


    // $ANTLR start "rule__Zone__NodesAssignment_10"
    // InternalDasl.g:3309:1: rule__Zone__NodesAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__Zone__NodesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3313:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3314:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3314:2: ( ( RULE_ID ) )
            // InternalDasl.g:3315:3: ( RULE_ID )
            {
             before(grammarAccess.getZoneAccess().getNodesNodeCrossReference_10_0()); 
            // InternalDasl.g:3316:3: ( RULE_ID )
            // InternalDasl.g:3317:4: RULE_ID
            {
             before(grammarAccess.getZoneAccess().getNodesNodeIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getNodesNodeIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getZoneAccess().getNodesNodeCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__NodesAssignment_10"


    // $ANTLR start "rule__Zone__ControlsAssignment_11_1"
    // InternalDasl.g:3328:1: rule__Zone__ControlsAssignment_11_1 : ( ( RULE_ID ) ) ;
    public final void rule__Zone__ControlsAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3332:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3333:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3333:2: ( ( RULE_ID ) )
            // InternalDasl.g:3334:3: ( RULE_ID )
            {
             before(grammarAccess.getZoneAccess().getControlsControlCrossReference_11_1_0()); 
            // InternalDasl.g:3335:3: ( RULE_ID )
            // InternalDasl.g:3336:4: RULE_ID
            {
             before(grammarAccess.getZoneAccess().getControlsControlIDTerminalRuleCall_11_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getZoneAccess().getControlsControlIDTerminalRuleCall_11_1_0_1()); 

            }

             after(grammarAccess.getZoneAccess().getControlsControlCrossReference_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Zone__ControlsAssignment_11_1"


    // $ANTLR start "rule__Node__NameAssignment_1"
    // InternalDasl.g:3347:1: rule__Node__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3351:1: ( ( RULE_ID ) )
            // InternalDasl.g:3352:2: ( RULE_ID )
            {
            // InternalDasl.g:3352:2: ( RULE_ID )
            // InternalDasl.g:3353:3: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__NameAssignment_1"


    // $ANTLR start "rule__Node__RefAssignment_4"
    // InternalDasl.g:3362:1: rule__Node__RefAssignment_4 : ( RULE_ID ) ;
    public final void rule__Node__RefAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3366:1: ( ( RULE_ID ) )
            // InternalDasl.g:3367:2: ( RULE_ID )
            {
            // InternalDasl.g:3367:2: ( RULE_ID )
            // InternalDasl.g:3368:3: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getRefIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRefIDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__RefAssignment_4"


    // $ANTLR start "rule__Node__HostAssignment_6"
    // InternalDasl.g:3377:1: rule__Node__HostAssignment_6 : ( RULE_STRING ) ;
    public final void rule__Node__HostAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3381:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3382:2: ( RULE_STRING )
            {
            // InternalDasl.g:3382:2: ( RULE_STRING )
            // InternalDasl.g:3383:3: RULE_STRING
            {
             before(grammarAccess.getNodeAccess().getHostSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getHostSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__HostAssignment_6"


    // $ANTLR start "rule__Node__OsAssignment_8"
    // InternalDasl.g:3392:1: rule__Node__OsAssignment_8 : ( RULE_STRING ) ;
    public final void rule__Node__OsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3396:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3397:2: ( RULE_STRING )
            {
            // InternalDasl.g:3397:2: ( RULE_STRING )
            // InternalDasl.g:3398:3: RULE_STRING
            {
             before(grammarAccess.getNodeAccess().getOsSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getOsSTRINGTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__OsAssignment_8"


    // $ANTLR start "rule__Node__ValueAssignment_10"
    // InternalDasl.g:3407:1: rule__Node__ValueAssignment_10 : ( ruleNodeType ) ;
    public final void rule__Node__ValueAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3411:1: ( ( ruleNodeType ) )
            // InternalDasl.g:3412:2: ( ruleNodeType )
            {
            // InternalDasl.g:3412:2: ( ruleNodeType )
            // InternalDasl.g:3413:3: ruleNodeType
            {
             before(grammarAccess.getNodeAccess().getValueNodeTypeEnumRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeType();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getValueNodeTypeEnumRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ValueAssignment_10"


    // $ANTLR start "rule__Node__ComponentsAssignment_12"
    // InternalDasl.g:3422:1: rule__Node__ComponentsAssignment_12 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ComponentsAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3426:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3427:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3427:2: ( ( RULE_ID ) )
            // InternalDasl.g:3428:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getComponentsComponentCrossReference_12_0()); 
            // InternalDasl.g:3429:3: ( RULE_ID )
            // InternalDasl.g:3430:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getComponentsComponentIDTerminalRuleCall_12_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getComponentsComponentIDTerminalRuleCall_12_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getComponentsComponentCrossReference_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ComponentsAssignment_12"


    // $ANTLR start "rule__Component__NameAssignment_1"
    // InternalDasl.g:3441:1: rule__Component__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Component__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3445:1: ( ( RULE_ID ) )
            // InternalDasl.g:3446:2: ( RULE_ID )
            {
            // InternalDasl.g:3446:2: ( RULE_ID )
            // InternalDasl.g:3447:3: RULE_ID
            {
             before(grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__NameAssignment_1"


    // $ANTLR start "rule__Component__RefAssignment_4"
    // InternalDasl.g:3456:1: rule__Component__RefAssignment_4 : ( RULE_ID ) ;
    public final void rule__Component__RefAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3460:1: ( ( RULE_ID ) )
            // InternalDasl.g:3461:2: ( RULE_ID )
            {
            // InternalDasl.g:3461:2: ( RULE_ID )
            // InternalDasl.g:3462:3: RULE_ID
            {
             before(grammarAccess.getComponentAccess().getRefIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getRefIDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__RefAssignment_4"


    // $ANTLR start "rule__Component__StereotypeAssignment_6"
    // InternalDasl.g:3471:1: rule__Component__StereotypeAssignment_6 : ( RULE_STRING ) ;
    public final void rule__Component__StereotypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3475:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3476:2: ( RULE_STRING )
            {
            // InternalDasl.g:3476:2: ( RULE_STRING )
            // InternalDasl.g:3477:3: RULE_STRING
            {
             before(grammarAccess.getComponentAccess().getStereotypeSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getStereotypeSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__StereotypeAssignment_6"


    // $ANTLR start "rule__Component__VendorAssignment_7_1"
    // InternalDasl.g:3486:1: rule__Component__VendorAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__Component__VendorAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3490:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3491:2: ( RULE_STRING )
            {
            // InternalDasl.g:3491:2: ( RULE_STRING )
            // InternalDasl.g:3492:3: RULE_STRING
            {
             before(grammarAccess.getComponentAccess().getVendorSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getVendorSTRINGTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__VendorAssignment_7_1"


    // $ANTLR start "rule__Component__DescAssignment_9"
    // InternalDasl.g:3501:1: rule__Component__DescAssignment_9 : ( RULE_STRING ) ;
    public final void rule__Component__DescAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3505:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3506:2: ( RULE_STRING )
            {
            // InternalDasl.g:3506:2: ( RULE_STRING )
            // InternalDasl.g:3507:3: RULE_STRING
            {
             before(grammarAccess.getComponentAccess().getDescSTRINGTerminalRuleCall_9_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getDescSTRINGTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__DescAssignment_9"


    // $ANTLR start "rule__Component__VersionAssignment_11"
    // InternalDasl.g:3516:1: rule__Component__VersionAssignment_11 : ( RULE_STRING ) ;
    public final void rule__Component__VersionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3520:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3521:2: ( RULE_STRING )
            {
            // InternalDasl.g:3521:2: ( RULE_STRING )
            // InternalDasl.g:3522:3: RULE_STRING
            {
             before(grammarAccess.getComponentAccess().getVersionSTRINGTerminalRuleCall_11_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getComponentAccess().getVersionSTRINGTerminalRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__VersionAssignment_11"


    // $ANTLR start "rule__Component__AssetsAssignment_13"
    // InternalDasl.g:3531:1: rule__Component__AssetsAssignment_13 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Component__AssetsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3535:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDasl.g:3536:2: ( ( ruleQualifiedName ) )
            {
            // InternalDasl.g:3536:2: ( ( ruleQualifiedName ) )
            // InternalDasl.g:3537:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComponentAccess().getAssetsInformationAssetCrossReference_13_0()); 
            // InternalDasl.g:3538:3: ( ruleQualifiedName )
            // InternalDasl.g:3539:4: ruleQualifiedName
            {
             before(grammarAccess.getComponentAccess().getAssetsInformationAssetQualifiedNameParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComponentAccess().getAssetsInformationAssetQualifiedNameParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getComponentAccess().getAssetsInformationAssetCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__AssetsAssignment_13"


    // $ANTLR start "rule__Component__ComponentsAssignment_14"
    // InternalDasl.g:3550:1: rule__Component__ComponentsAssignment_14 : ( ruleComponent ) ;
    public final void rule__Component__ComponentsAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3554:1: ( ( ruleComponent ) )
            // InternalDasl.g:3555:2: ( ruleComponent )
            {
            // InternalDasl.g:3555:2: ( ruleComponent )
            // InternalDasl.g:3556:3: ruleComponent
            {
             before(grammarAccess.getComponentAccess().getComponentsComponentParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleComponent();

            state._fsp--;

             after(grammarAccess.getComponentAccess().getComponentsComponentParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Component__ComponentsAssignment_14"


    // $ANTLR start "rule__InformationAsset__NameAssignment_1"
    // InternalDasl.g:3565:1: rule__InformationAsset__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__InformationAsset__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3569:1: ( ( RULE_ID ) )
            // InternalDasl.g:3570:2: ( RULE_ID )
            {
            // InternalDasl.g:3570:2: ( RULE_ID )
            // InternalDasl.g:3571:3: RULE_ID
            {
             before(grammarAccess.getInformationAssetAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__NameAssignment_1"


    // $ANTLR start "rule__InformationAsset__RefAssignment_4"
    // InternalDasl.g:3580:1: rule__InformationAsset__RefAssignment_4 : ( RULE_ID ) ;
    public final void rule__InformationAsset__RefAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3584:1: ( ( RULE_ID ) )
            // InternalDasl.g:3585:2: ( RULE_ID )
            {
            // InternalDasl.g:3585:2: ( RULE_ID )
            // InternalDasl.g:3586:3: RULE_ID
            {
             before(grammarAccess.getInformationAssetAccess().getRefIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getRefIDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__RefAssignment_4"


    // $ANTLR start "rule__InformationAsset__DescAssignment_6"
    // InternalDasl.g:3595:1: rule__InformationAsset__DescAssignment_6 : ( RULE_STRING ) ;
    public final void rule__InformationAsset__DescAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3599:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3600:2: ( RULE_STRING )
            {
            // InternalDasl.g:3600:2: ( RULE_STRING )
            // InternalDasl.g:3601:3: RULE_STRING
            {
             before(grammarAccess.getInformationAssetAccess().getDescSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInformationAssetAccess().getDescSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__DescAssignment_6"


    // $ANTLR start "rule__InformationAsset__ConfidentialityAssignment_8"
    // InternalDasl.g:3610:1: rule__InformationAsset__ConfidentialityAssignment_8 : ( ruleConfidentialityType ) ;
    public final void rule__InformationAsset__ConfidentialityAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3614:1: ( ( ruleConfidentialityType ) )
            // InternalDasl.g:3615:2: ( ruleConfidentialityType )
            {
            // InternalDasl.g:3615:2: ( ruleConfidentialityType )
            // InternalDasl.g:3616:3: ruleConfidentialityType
            {
             before(grammarAccess.getInformationAssetAccess().getConfidentialityConfidentialityTypeEnumRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleConfidentialityType();

            state._fsp--;

             after(grammarAccess.getInformationAssetAccess().getConfidentialityConfidentialityTypeEnumRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__ConfidentialityAssignment_8"


    // $ANTLR start "rule__InformationAsset__IntegrityAssignment_10"
    // InternalDasl.g:3625:1: rule__InformationAsset__IntegrityAssignment_10 : ( ruleIntegrityType ) ;
    public final void rule__InformationAsset__IntegrityAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3629:1: ( ( ruleIntegrityType ) )
            // InternalDasl.g:3630:2: ( ruleIntegrityType )
            {
            // InternalDasl.g:3630:2: ( ruleIntegrityType )
            // InternalDasl.g:3631:3: ruleIntegrityType
            {
             before(grammarAccess.getInformationAssetAccess().getIntegrityIntegrityTypeEnumRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegrityType();

            state._fsp--;

             after(grammarAccess.getInformationAssetAccess().getIntegrityIntegrityTypeEnumRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__IntegrityAssignment_10"


    // $ANTLR start "rule__InformationAsset__AvailabilityAssignment_12"
    // InternalDasl.g:3640:1: rule__InformationAsset__AvailabilityAssignment_12 : ( ruleAvailabilityType ) ;
    public final void rule__InformationAsset__AvailabilityAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3644:1: ( ( ruleAvailabilityType ) )
            // InternalDasl.g:3645:2: ( ruleAvailabilityType )
            {
            // InternalDasl.g:3645:2: ( ruleAvailabilityType )
            // InternalDasl.g:3646:3: ruleAvailabilityType
            {
             before(grammarAccess.getInformationAssetAccess().getAvailabilityAvailabilityTypeEnumRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleAvailabilityType();

            state._fsp--;

             after(grammarAccess.getInformationAssetAccess().getAvailabilityAvailabilityTypeEnumRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InformationAsset__AvailabilityAssignment_12"


    // $ANTLR start "rule__Flow__NameAssignment_1"
    // InternalDasl.g:3655:1: rule__Flow__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Flow__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3659:1: ( ( RULE_ID ) )
            // InternalDasl.g:3660:2: ( RULE_ID )
            {
            // InternalDasl.g:3660:2: ( RULE_ID )
            // InternalDasl.g:3661:3: RULE_ID
            {
             before(grammarAccess.getFlowAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__NameAssignment_1"


    // $ANTLR start "rule__Flow__FromAssignment_4"
    // InternalDasl.g:3670:1: rule__Flow__FromAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Flow__FromAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3674:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3675:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3675:2: ( ( RULE_ID ) )
            // InternalDasl.g:3676:3: ( RULE_ID )
            {
             before(grammarAccess.getFlowAccess().getFromComponentCrossReference_4_0()); 
            // InternalDasl.g:3677:3: ( RULE_ID )
            // InternalDasl.g:3678:4: RULE_ID
            {
             before(grammarAccess.getFlowAccess().getFromComponentIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getFromComponentIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getFromComponentCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__FromAssignment_4"


    // $ANTLR start "rule__Flow__ToAssignment_6"
    // InternalDasl.g:3689:1: rule__Flow__ToAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__Flow__ToAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3693:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3694:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3694:2: ( ( RULE_ID ) )
            // InternalDasl.g:3695:3: ( RULE_ID )
            {
             before(grammarAccess.getFlowAccess().getToComponentCrossReference_6_0()); 
            // InternalDasl.g:3696:3: ( RULE_ID )
            // InternalDasl.g:3697:4: RULE_ID
            {
             before(grammarAccess.getFlowAccess().getToComponentIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getToComponentIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getToComponentCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__ToAssignment_6"


    // $ANTLR start "rule__Flow__AssetsAssignment_8"
    // InternalDasl.g:3708:1: rule__Flow__AssetsAssignment_8 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Flow__AssetsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3712:1: ( ( ( ruleQualifiedName ) ) )
            // InternalDasl.g:3713:2: ( ( ruleQualifiedName ) )
            {
            // InternalDasl.g:3713:2: ( ( ruleQualifiedName ) )
            // InternalDasl.g:3714:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getFlowAccess().getAssetsInformationAssetCrossReference_8_0()); 
            // InternalDasl.g:3715:3: ( ruleQualifiedName )
            // InternalDasl.g:3716:4: ruleQualifiedName
            {
             before(grammarAccess.getFlowAccess().getAssetsInformationAssetQualifiedNameParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getAssetsInformationAssetQualifiedNameParserRuleCall_8_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getAssetsInformationAssetCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__AssetsAssignment_8"


    // $ANTLR start "rule__Flow__ControlsAssignment_10"
    // InternalDasl.g:3727:1: rule__Flow__ControlsAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__Flow__ControlsAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3731:1: ( ( ( RULE_ID ) ) )
            // InternalDasl.g:3732:2: ( ( RULE_ID ) )
            {
            // InternalDasl.g:3732:2: ( ( RULE_ID ) )
            // InternalDasl.g:3733:3: ( RULE_ID )
            {
             before(grammarAccess.getFlowAccess().getControlsControlCrossReference_10_0()); 
            // InternalDasl.g:3734:3: ( RULE_ID )
            // InternalDasl.g:3735:4: RULE_ID
            {
             before(grammarAccess.getFlowAccess().getControlsControlIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getControlsControlIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getControlsControlCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__ControlsAssignment_10"


    // $ANTLR start "rule__Control__NameAssignment_1"
    // InternalDasl.g:3746:1: rule__Control__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Control__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3750:1: ( ( RULE_ID ) )
            // InternalDasl.g:3751:2: ( RULE_ID )
            {
            // InternalDasl.g:3751:2: ( RULE_ID )
            // InternalDasl.g:3752:3: RULE_ID
            {
             before(grammarAccess.getControlAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__NameAssignment_1"


    // $ANTLR start "rule__Control__RefAssignment_4"
    // InternalDasl.g:3761:1: rule__Control__RefAssignment_4 : ( RULE_ID ) ;
    public final void rule__Control__RefAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3765:1: ( ( RULE_ID ) )
            // InternalDasl.g:3766:2: ( RULE_ID )
            {
            // InternalDasl.g:3766:2: ( RULE_ID )
            // InternalDasl.g:3767:3: RULE_ID
            {
             before(grammarAccess.getControlAccess().getRefIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getRefIDTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__RefAssignment_4"


    // $ANTLR start "rule__Control__AreaAssignment_6"
    // InternalDasl.g:3776:1: rule__Control__AreaAssignment_6 : ( ruleControlType ) ;
    public final void rule__Control__AreaAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3780:1: ( ( ruleControlType ) )
            // InternalDasl.g:3781:2: ( ruleControlType )
            {
            // InternalDasl.g:3781:2: ( ruleControlType )
            // InternalDasl.g:3782:3: ruleControlType
            {
             before(grammarAccess.getControlAccess().getAreaControlTypeEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleControlType();

            state._fsp--;

             after(grammarAccess.getControlAccess().getAreaControlTypeEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__AreaAssignment_6"


    // $ANTLR start "rule__Control__ImplementationAssignment_8"
    // InternalDasl.g:3791:1: rule__Control__ImplementationAssignment_8 : ( RULE_STRING ) ;
    public final void rule__Control__ImplementationAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDasl.g:3795:1: ( ( RULE_STRING ) )
            // InternalDasl.g:3796:2: ( RULE_STRING )
            {
            // InternalDasl.g:3796:2: ( RULE_STRING )
            // InternalDasl.g:3797:3: RULE_STRING
            {
             before(grammarAccess.getControlAccess().getImplementationSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getControlAccess().getImplementationSTRINGTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Control__ImplementationAssignment_8"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000000111041018L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000C00L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000900000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000010L,0x0000000000040400L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x01C0000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x1E00000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x003FFFFFFFFFC000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});

}