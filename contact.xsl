<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Address</h2>
  <xsl:for-each select="Address/DoorNo">
   <xsl:value-of select="@DoorNo"/>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>
