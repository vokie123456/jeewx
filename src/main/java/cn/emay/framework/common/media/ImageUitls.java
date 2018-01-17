package cn.emay.framework.common.media;

import java.awt.image.BufferedImage;

public class ImageUitls {

	/**
	 * ǿ�����ûҶȻ��ķ�����Ч����ԾͲ ͼƬ�һ���Ч�����У������顣��˵��������Javaʵ�ֻҶȻ�����ʮ�а˾Ŷ���һ�ַ�����
	 * 
	 * @param bufferedImage
	 *            ������ͼƬ
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage grayImage1(BufferedImage bufferedImage) throws Exception {

		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();

		BufferedImage grayBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				grayBufferedImage.setRGB(x, y, bufferedImage.getRGB(x, y));
			}
		}
		return grayBufferedImage;
	}

	/**
	 * ��Ȩ���ҶȻ���Ч���Ϻã� ͼƬ�һ����ο���http://www.codeceo.com/article/java-image-gray.html��
	 * 
	 * @param bufferedImage
	 *            ������ͼƬ
	 * @return
	 * @throws Exception
	 */
	public static BufferedImage grayImage(BufferedImage bufferedImage) throws Exception {

		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();

		BufferedImage grayBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// ����Ҷ�ֵ
				final int color = bufferedImage.getRGB(x, y);
				final int r = (color >> 16) & 0xff;
				final int g = (color >> 8) & 0xff;
				final int b = color & 0xff;
				int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
				int newPixel = colorToRGB(255, gray, gray, gray);
				grayBufferedImage.setRGB(x, y, newPixel);
			}
		}

		return grayBufferedImage;

	}

	/**
	 * ��ɫ����ת��ΪRGBֵ
	 * 
	 * @param alpha
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	private static int colorToRGB(int alpha, int red, int green, int blue) {

		int newPixel = 0;
		newPixel += alpha;
		newPixel = newPixel << 8;
		newPixel += red;
		newPixel = newPixel << 8;
		newPixel += green;
		newPixel = newPixel << 8;
		newPixel += blue;

		return newPixel;

	}

}
