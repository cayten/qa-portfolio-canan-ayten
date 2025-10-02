import pytest

@pytest.mark.parametrize("username,password", [
    ("standard_user", "secret_sauce"),
])
def test_login_logout(page, username, password):
    page.goto("https://www.saucedemo.com/")
    page.fill("#user-name", username)
    page.fill("#password", password)
    page.click("#login-button")
    page.wait_for_selector(".inventory_list")
    assert "inventory" in page.url

    page.click("#react-burger-menu-btn")
    page.click("#logout_sidebar_link")
    page.wait_for_selector("#login-button")
    assert "saucedemo" in page.url
