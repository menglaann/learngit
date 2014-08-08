import cgi
from google.appengine.api import users
import webapp2
from google.appengine.ext import ndb
from google.appengine.api import urlfetch

urlfetch.set_default_fetch_deadline(60)

MAIN_PAGE_HTML = """\
<html>
  <body>
    <form action="/sign" method="post">
        <button>post</button>
    </form>
  </body>
</html>
"""
url = 'https://58.247.178.239:8443/parking/countdown/gfgADSFDF?count=10'
class MainPage(webapp2.RequestHandler):
    def get(self):
        f=open('workfile.txt','r')
        self.response.write(MAIN_PAGE_HTML)
        self.response.write(f.read())


class Guestbook(webapp2.RequestHandler):
    def post(self):
	    #url = "https://58.247.178.239:8443/parking/countdown/gfgADSFDF?count=10"
        self.response.write('111')
        result = urlfetch.fetch(url)
		#if result.status_code == 200:
		#    self.response.write(result.content)
            

application = webapp2.WSGIApplication([
    ('/', MainPage),
    ('/sign', Guestbook),
], debug=True)
