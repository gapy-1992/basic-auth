import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Login at Page home'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 2: Navigate to Page home'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/')

'step 3: At Page home click on div root'

testObj = findTestObject('Object Repository/Page_home/div_root')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 4: At Page home click on hyperlink object --> navigate to Page cart html'

testObj = findTestObject('Object Repository/Page_home/hyperlink_object')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 5: Add visual checkpoint at Page cart html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Verify Successful Login and Navigation to Cart Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
